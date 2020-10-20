package com.example.f1repository.dagger

import com.example.f1repository.RaceResultsRepository
import com.example.f1repository.RaceScheduleRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule(var season: String) {

    @Singleton
    @Provides
    fun getRaceResultsRepository(): RaceResultsRepository {
        return RaceResultsRepository(season)
    }

    @Singleton
    @Provides
    fun getRaceScheduleRepository(): RaceScheduleRepository {
        return RaceScheduleRepository(season)
    }

}
