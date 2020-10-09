package com.example.retrofit.dataprovider

import com.example.models.seasons.SeasonsListWrapperModel
import com.example.retrofit.apiinterface.SeasonsListRequest
import com.example.retrofit.communicator.SeasonsListCommunicator
import com.example.retrofit.dagger.DaggerRetrofitComponent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject


class SeasonListRemoteDataProvider(var communicator: SeasonsListCommunicator) {

    @Inject lateinit var retrofitClient: Retrofit

    init {
        DaggerRetrofitComponent.create().inject(this)
    }

    private var seasonsListApiService: SeasonsListRequest =
        retrofitClient.create(SeasonsListRequest::class.java)

    suspend fun getSeasonsListFromRemoteStorage() {
        seasonsListApiService.getAllSeasons()?.enqueue(object : Callback<SeasonsListWrapperModel> {
            override fun onFailure(call: Call<SeasonsListWrapperModel>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<SeasonsListWrapperModel>,
                response: Response<SeasonsListWrapperModel>
            ) {
                TODO("Not yet implemented")
            }
        })
    }
}
