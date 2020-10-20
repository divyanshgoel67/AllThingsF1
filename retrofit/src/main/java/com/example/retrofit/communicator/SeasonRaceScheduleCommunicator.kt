package com.example.retrofit.communicator

import com.example.models.raceschedule.SeasonRaceScheduleWrapperModel

interface SeasonRaceScheduleCommunicator {

    fun onScheduleDataSuccessful(result: SeasonRaceScheduleWrapperModel?)

    fun onResultFailed(reason: String)
}
