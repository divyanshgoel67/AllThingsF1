package com.example.f1repository.dagger

import com.example.database.F1Database
import com.example.database.RaceResultsDao
import com.example.database.SeasonsListDao
import com.example.f1repository.RaceResultsRepository
import com.example.f1repository.RaceScheduleRepository
import com.example.f1repository.SeasonsListRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DatabaseModule::class])
interface DatabaseComponent {

    fun getDatabase() : F1Database

    fun getRaceResultsDao() : RaceResultsDao

    fun getSeasonsListDao() : SeasonsListDao

    fun inject(repository : RaceResultsRepository)

    fun inject(repository : SeasonsListRepository)

    fun inject(repository : RaceScheduleRepository)

}
