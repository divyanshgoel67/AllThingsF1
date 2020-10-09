package com.example.retrofit.dagger

import com.example.retrofit.SeasonListRemoteDataProvider
import com.example.retrofit.SeasonRaceResultsRemoteDataProvider
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class])
interface RetrofitComponent {
    fun getRetrofitClient(): Retrofit
    fun injectSeasonRaceResultsProvider(raceResultsProvider: SeasonRaceResultsRemoteDataProvider)
    fun injectSeasonsListProvider(seasonsListProvider: SeasonListRemoteDataProvider)
}
