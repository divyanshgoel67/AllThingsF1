package com.example.retrofit.apiinterface

import com.example.models.raceresult.SeasonRaceResultsWrapperModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RaceResultsRequest {

    @GET("{season}/results.json")
    suspend fun getSeasonRaceResults(@Path ("season") season : String): Call<SeasonRaceResultsWrapperModel>?
}
