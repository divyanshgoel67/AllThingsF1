package com.example.allthingsf1.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.f1repository.RaceResultsRepository
import com.example.models.raceresult.RaceResultsModel

class RaceResultsViewModel(var season: String, var applicationContext: Context) : ViewModel() {

    var repository: RaceResultsRepository = RaceResultsRepository(season, applicationContext)

    var seasonRaceResultsData : LiveData<List<RaceResultsModel>> = repository.getCurrentSeasonRaceResults()

    var resultsFailedNotifier: LiveData<String> = repository.getFailedResultsLiveData()

}
