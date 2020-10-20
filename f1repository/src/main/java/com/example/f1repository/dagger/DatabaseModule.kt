package com.example.f1repository.dagger

import android.content.Context
import androidx.room.Room
import com.example.dagger.ApplicationContextQualifier
import com.example.database.F1Database
import com.example.database.RaceResultsDao
import com.example.database.RaceScheduleDao
import com.example.database.SeasonsListDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(@ApplicationContextQualifier var context: Context) {

    @Singleton
    @Provides
    fun getDatabase(): F1Database {
        return Room.databaseBuilder(
            context,
            F1Database::class.java,
            "f1_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun getRaceResultsDao() : RaceResultsDao {
        return getDatabase().raceResultsDao()
    }

    @Singleton
    @Provides
    fun getSeasonsListDao() : SeasonsListDao {
        return getDatabase().seasonsListDao()
    }

    @Singleton
    @Provides
    fun getScheduleDao() : RaceScheduleDao {
        return getDatabase().scheduleDao()
    }

}
