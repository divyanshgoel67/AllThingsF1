package com.example.f1repository.dagger

import com.example.f1repository.SeasonsListRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StaticRepositoryModule {

    companion object {

        @Singleton
        @Provides
        fun getSeasonsListRepository() : SeasonsListRepository {
            return SeasonsListRepository()
        }
    }
}
