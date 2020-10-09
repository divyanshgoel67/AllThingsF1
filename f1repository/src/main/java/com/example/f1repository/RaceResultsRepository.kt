package com.example.f1repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.database.F1Database
import com.example.f1repository.dagger.DaggerDatabaseComponent
import com.example.models.raceresult.DriverPositionResultsModel
import com.example.models.raceresult.RaceResultsModel
import com.example.models.raceresult.FinalGridPositionModel
import com.example.models.raceresult.RaceDetailModel
import com.example.models.raceresult.SeasonRaceResultsWrapperModel
import com.example.retrofit.communicator.SeasonRaceResultsCommunicator
import com.example.retrofit.dataprovider.SeasonRaceResultsRemoteDataProvider
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
class RaceResultsRepository(
    var season: String,
    var context: Context
) {

    @Inject
    lateinit var database: F1Database

    var raceResultsCommunicator = object : SeasonRaceResultsCommunicator {
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

    init {
        DaggerDatabaseComponent
            .builder()
            .context(context)
            .build()
            .inject(this)
    }

    private var raceResultsDao = database.raceResultsDao()

    private var remoteDataProvider: SeasonRaceResultsRemoteDataProvider =
        SeasonRaceResultsRemoteDataProvider(raceResultsCommunicator)

    private var seasonRaceResultsFailedLiveData = MutableLiveData<String>()

    fun getCurrentSeasonRaceResults(): LiveData<List<RaceResultsModel>> {
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
        var finalResult =
            DriverPositionResultsModel(
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

//    override fun onSeasonRaceResultsSuccessful(result: SeasonRaceResultsWrapperModel?) {
//
//        CoroutineScope(Dispatchers.IO).launch {
//            var seasonRaceResultsArray: List<DriverPositionResultsModel> = ArrayList()
//            result?.data?.raceTable?.races?.asFlow()
//                ?.map { it -> convertRaceResultsData(it) }
//                ?.flowOn(Dispatchers.Default)
//                ?.collect { it -> raceResultsDao.insertSeasonRaceDetails(it) }
//        }
//
//    }
//
//    override fun onSeasonRaceResultsFailed(reason: String) {
//        seasonRaceResultsFailedLiveData.value = reason
//    }
//
//    override fun onRaceDataSuccessful() {
//        TODO("Not yet implemented")
//    }
//
//    override fun onRaceDataFailed() {
//        TODO("Not yet implemented")
//    }

}
