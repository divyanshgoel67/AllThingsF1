package com.example.retrofit

import com.example.models.raceresult.SeasonRaceResultsWrapperModel
import com.example.retrofit.apiinterface.RaceResultsRequest
import com.example.retrofit.dagger.DaggerRetrofitComponent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class SeasonRaceResultsRemoteDataProvider(
    var communicator: SeasonRaceResultsCommunicator) {

    @Inject lateinit var retrofitClient : Retrofit

    init {
        DaggerRetrofitComponent.create().injectSeasonRaceResultsProvider(this)
    }

    private var raceResultsApiService: RaceResultsRequest = retrofitClient.create(RaceResultsRequest::class.java)

    suspend fun getSeasonRaceResultsFromRemoteStorage(season : String) {
        raceResultsApiService.getSeasonRaceResults(season)?.enqueue(object : Callback<SeasonRaceResultsWrapperModel> {
            override fun onFailure(call: Call<SeasonRaceResultsWrapperModel>, t: Throwable) {
                communicator.onSeasonRaceResultsFailed(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<SeasonRaceResultsWrapperModel>,
                response: Response<SeasonRaceResultsWrapperModel>
            ) {
                if (response.isSuccessful) {
                    communicator.onSeasonRaceResultsSuccessful(response.body())
                }
            }

        })
    }
}
