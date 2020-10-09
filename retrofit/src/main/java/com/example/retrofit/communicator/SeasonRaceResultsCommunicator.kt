package com.example.retrofit.communicator

import com.example.models.raceresult.SeasonRaceResultsWrapperModel

interface SeasonRaceResultsCommunicator {

    fun onSeasonRaceResultsSuccessful(result : SeasonRaceResultsWrapperModel?)

    fun onSeasonRaceResultsFailed(reason : String)

    fun onRaceDataSuccessful()

    fun onRaceDataFailed()
}
