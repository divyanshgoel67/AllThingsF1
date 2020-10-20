package com.example.f1repository

import androidx.lifecycle.MutableLiveData
import com.example.database.F1Database
import com.example.database.RaceScheduleDao
import com.example.models.raceschedule.RaceScheduleDetailModel
import com.example.models.raceschedule.ScheduleEntityModel
import com.example.models.raceschedule.SeasonRaceScheduleWrapperModel
import com.example.retrofit.communicator.SeasonRaceScheduleCommunicator
import com.example.retrofit.dataprovider.SeasonRaceScheduleRemoteDataProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RaceScheduleRepository(var season: String) {

    @Inject
    lateinit var database: F1Database

    @Inject
    lateinit var scheduleDao: RaceScheduleDao

    var completedRaces: Int = 0

    init {
        RepositoryInitialiser.instance.getDataBaseComponent().inject(this)
    }

    var scheduleDataFailedLiveData: MutableLiveData<String> = MutableLiveData()

    var raceScheduleData: MutableLiveData<List<ScheduleEntityModel>> = MutableLiveData()


    private val communicator = object : SeasonRaceScheduleCommunicator {
        override fun onScheduleDataSuccessful(result: SeasonRaceScheduleWrapperModel?) {

            CoroutineScope(Dispatchers.Main).launch {
                raceScheduleData.value = result?.data?.raceTable?.Races?.asFlow()
                    ?.map { it -> convertRaceScheduleData(it) }
                    ?.filter { it -> filterRaceScheduleData(it) }
                    ?.flowOn(Dispatchers.Default)
                    ?.toList()
            }
        }

        override fun onResultFailed(reason: String) {
            scheduleDataFailedLiveData.value = reason
        }

    }

    private var remoteDataProvider = SeasonRaceScheduleRemoteDataProvider(communicator)

    fun getSeasonRaceSchedule(completedRaces: Int) {
        this.completedRaces = completedRaces
        remoteDataProvider.getRaceScheduleFromRemoteStorage(season)
    }

    private fun convertRaceScheduleData(result: RaceScheduleDetailModel): ScheduleEntityModel {

        return ScheduleEntityModel(
            result.season,
            result.round,
            result.raceName,
            result.circuit.circuitName,
            result.circuit.location.country,
            result.date
        )
    }

    private fun filterRaceScheduleData(result: ScheduleEntityModel): Boolean {
        return result.raceNumber > completedRaces
    }
}
