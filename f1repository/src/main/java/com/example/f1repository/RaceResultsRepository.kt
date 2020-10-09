package com.example.f1repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.database.F1Database
import com.example.database.models.DriverPositionResultsModel
import com.example.database.models.RaceResultsModel
import com.example.models.raceresult.FinalGridPositionModel
import com.example.models.raceresult.RaceDetailModel
import com.example.models.raceresult.SeasonRaceResultsWrapperModel
import com.example.retrofit.SeasonRaceResultsCommunicator
import com.example.retrofit.SeasonRaceResultsRemoteDataProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RaceResultsRepository @Inject constructor(
    var season: String,
    var database: F1Database
) : SeasonRaceResultsCommunicator {

    private var raceResultsDao = database.raceResultsDao()

    var remoteDataProvider: SeasonRaceResultsRemoteDataProvider =
        SeasonRaceResultsRemoteDataProvider(this)

    var seasonRaceResultsFailedLiveData = MutableLiveData<String>()

    suspend fun getCurrentSeasonRaceResults(): LiveData<List<RaceResultsModel>> {
        CoroutineScope(Dispatchers.Default).launch {
            if (checkIfSeasonDataIsPresent()) {
                remoteDataProvider.getSeasonRaceResultsFromRemoteStorage(season)
            }
        }
        return raceResultsDao.getSeasonRaceResults(season)
    }

    fun getFailedResultsLiveData() : LiveData<String> {
        return seasonRaceResultsFailedLiveData
    }

    private suspend fun checkIfSeasonDataIsPresent(): Boolean {
        return raceResultsDao.getSeasonDataCount(season) != 0
    }

    private suspend fun convertRaceResultsData(result: RaceDetailModel): RaceResultsModel {

        var driverPositionList = convertDriverPositionData(result.results)

        return RaceResultsModel(
            result.season,
            result.round,
            result.raceName,
            result.circuit.circuitName,
            driverPositionList as ArrayList<DriverPositionResultsModel>
        )

    }

    private suspend fun convertDriverPositionData(result: List<FinalGridPositionModel>): List<DriverPositionResultsModel> {

        var finalResult: ArrayList<DriverPositionResultsModel> = ArrayList()
        result.asFlow()
            .map { it -> convertDriverDataFromFlow(it) }
            .collect { finalResult.add(it) }

        var driverPositionComparator =
            Comparator<DriverPositionResultsModel> { o1, o2 ->
                if (o1!!.position < o2!!.position) {
                    1
                } else {
                    0
                }
            }

        finalResult.sortedWith(driverPositionComparator)

        return finalResult
    }

    private fun convertDriverDataFromFlow(result: FinalGridPositionModel): DriverPositionResultsModel {
        var finalResult = DriverPositionResultsModel(
            result.position,
            result.driver.permanentNumber,
            result.driver.nationality,
            result.constructor.name,
            result.status,
            result.time.time,
            result.fastestLap.time.time
        )

        finalResult.driver = "${result.driver.givenName} ${result.driver.familyName}"
        finalResult.avgSpeed = "${result.averageSpeed.speed} ${result.averageSpeed.units}"

        return finalResult
    }

    override fun onSeasonRaceResultsSuccessful(result: SeasonRaceResultsWrapperModel?) {

        CoroutineScope(Dispatchers.IO).launch {
            var seasonRaceResultsArray: List<DriverPositionResultsModel> = ArrayList()
            result?.data?.raceTable?.races?.asFlow()
                ?.map { it -> convertRaceResultsData(it) }
                ?.flowOn(Dispatchers.Default)
                ?.collect { it -> raceResultsDao.insertSeasonRaceDetails(it) }
        }

    }

    override fun onSeasonRaceResultsFailed(reason: String) {
        seasonRaceResultsFailedLiveData.value = reason
    }

    override fun onRaceDataSuccessful() {
        TODO("Not yet implemented")
    }

    override fun onRaceDataFailed() {
        TODO("Not yet implemented")
    }

}
