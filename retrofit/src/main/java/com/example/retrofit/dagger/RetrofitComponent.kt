package com.example.retrofit.dagger

import com.example.retrofit.dataprovider.SeasonListRemoteDataProvider
import com.example.retrofit.dataprovider.SeasonRaceResultsRemoteDataProvider
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class])
interface RetrofitComponent {
    fun getRetrofitClient(): Retrofit
    fun inject(raceResultsProvider: SeasonRaceResultsRemoteDataProvider)
    fun inject(seasonsListProvider: SeasonListRemoteDataProvider)
}
