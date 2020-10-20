package com.example.retrofit.apiinterface

import com.example.models.raceschedule.SeasonRaceScheduleWrapperModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RaceScheduleApi {

    @GET("{season}.json?limit=500")
    fun getRaceSchedule(@Path("season") season: String): Call<SeasonRaceScheduleWrapperModel>?

}
