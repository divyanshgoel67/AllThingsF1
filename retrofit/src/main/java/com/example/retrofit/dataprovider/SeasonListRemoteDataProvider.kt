package com.example.retrofit.dataprovider

import com.example.models.seasons.SeasonsListWrapperModel
import com.example.retrofit.RetrofitManager
import com.example.retrofit.apiinterface.SeasonsListRequest
import com.example.retrofit.communicator.SeasonsListCommunicator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject


class SeasonListRemoteDataProvider(var communicator: SeasonsListCommunicator) {

    @Inject lateinit var retrofitClient: Retrofit

    init {
        RetrofitManager.instance.getRetrofitComponent().inject(this)
    }

    private var seasonsListApiService: SeasonsListRequest =
        retrofitClient.create(SeasonsListRequest::class.java)

    fun getSeasonsListFromRemoteStorage() {
        seasonsListApiService.getAllSeasons()?.enqueue(object : Callback<SeasonsListWrapperModel> {
            override fun onFailure(call: Call<SeasonsListWrapperModel>, t: Throwable) {
                communicator.onSeasonsListResponseFailed(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<SeasonsListWrapperModel>,
                response: Response<SeasonsListWrapperModel>
            ) {
                communicator.onSeasonsListResponseSuccessful(response.body())
            }
        })
    }
}
