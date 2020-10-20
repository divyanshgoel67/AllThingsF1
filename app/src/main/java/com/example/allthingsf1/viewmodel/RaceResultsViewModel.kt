package com.example.allthingsf1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.allthingsf1.RepositoryManager
import com.example.f1repository.RaceResultsRepository
import com.example.f1repository.RaceScheduleRepository
import com.example.models.raceresult.RaceResultsModel
import com.example.models.raceschedule.ScheduleEntityModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class RaceResultsViewModel() : ViewModel() {

    @Inject lateinit var raceResultsRepo: RaceResultsRepository

    @Inject lateinit var raceScheduleRepository : RaceScheduleRepository

    init {
        RepositoryManager.instance.getRepositoryComponent().inject(this)
    }

    var raceScheduleData : LiveData<List<ScheduleEntityModel>> = raceScheduleRepository.raceScheduleData

    init {
        CoroutineScope(Dispatchers.IO).launch {
            val completedRaces = raceResultsRepo.getTotalCompletedRaces()
            raceScheduleRepository.getSeasonRaceSchedule(completedRaces)
        }
    }

    var seasonRaceResultsData : LiveData<List<RaceResultsModel>> = raceResultsRepo.getCurrentSeasonRaceResults()

    var resultsFailedNotifier: LiveData<String> = raceResultsRepo.getFailedResultsLiveData()

}
