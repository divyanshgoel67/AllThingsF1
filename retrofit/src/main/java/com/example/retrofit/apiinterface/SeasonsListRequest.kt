package com.example.retrofit.apiinterface

import com.example.models.seasons.SeasonsListWrapperModel
import retrofit2.Call
import retrofit2.http.GET

interface SeasonsListRequest {

    @GET("seasons.json?limit=150")
    fun getAllSeasons() : Call<SeasonsListWrapperModel>?
}
