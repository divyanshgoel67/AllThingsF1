package com.example.retrofit

import com.example.models.seasons.SeasonsListWrapperModel

interface SeasonsListCommunicator {

    fun onSeasonsListResponseSuccessful(result : SeasonsListWrapperModel?)

    fun onSeasonsListResponseFailed()
}
