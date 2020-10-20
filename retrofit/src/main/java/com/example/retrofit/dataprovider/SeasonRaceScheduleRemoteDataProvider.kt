package com.example.retrofit.dataprovider

import com.example.models.raceschedule.SeasonRaceScheduleWrapperModel
import com.example.retrofit.RetrofitManager
import com.example.retrofit.apiinterface.RaceScheduleApi
import com.example.retrofit.communicator.SeasonRaceScheduleCommunicator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class SeasonRaceScheduleRemoteDataProvider(var communicator: SeasonRaceScheduleCommunicator) {

    @Inject
    lateinit var retrofitClient: Retrofit

    init {
        RetrofitManager.instance.getRetrofitComponent().inject(this)
    }

    private var scheduleApi: RaceScheduleApi = retrofitClient.create(RaceScheduleApi::class.java)

    fun getRaceScheduleFromRemoteStorage(season: String) {
        scheduleApi.getRaceSchedule(season)
            ?.enqueue(object : Callback<SeasonRaceScheduleWrapperModel> {
                override fun onFailure(call: Call<SeasonRaceScheduleWrapperModel>, t: Throwable) {
                    communicator.onResultFailed(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<SeasonRaceScheduleWrapperModel>,
                    response: Response<SeasonRaceScheduleWrapperModel>
                ) {
                    communicator.onScheduleDataSuccessful(response.body())
                }

            })
    }

}
