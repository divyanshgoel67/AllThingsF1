package com.example.f1repository.dagger

import android.content.Context
import com.example.database.F1Database
import com.example.database.dagger.DatabaseModule
import com.example.f1repository.RaceResultsRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [DatabaseModule::class])
@Singleton
interface DatabaseComponent {

    fun getDatabaseObject() : F1Database

    fun inject(raceResultsRepository: RaceResultsRepository)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context : Context) : Builder

        fun build() : DatabaseComponent

    }

}
