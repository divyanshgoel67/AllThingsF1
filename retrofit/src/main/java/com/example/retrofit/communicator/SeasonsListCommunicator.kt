package com.example.retrofit.communicator

import com.example.models.seasons.SeasonsListWrapperModel

interface SeasonsListCommunicator {

    fun onSeasonsListResponseSuccessful(result : SeasonsListWrapperModel?)

    fun onSeasonsListResponseFailed()
}
