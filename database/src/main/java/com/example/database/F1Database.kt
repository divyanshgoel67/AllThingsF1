package com.example.database

import android.content.Context
import androidx.room.*
import com.example.database.models.DriverPositionResultsModel
import javax.inject.Singleton

@Database(entities = [DriverPositionResultsModel::class], version = 1)
@Singleton
@TypeConverters(Converter::class)
abstract class F1Database : RoomDatabase() {

    abstract fun raceResultsDao() : RaceResultsDao

    abstract fun seasonsListDao() : SeasonsListDao

    companion object {

        @Volatile
        private lateinit var instance : F1Database

        @Synchronized fun getInstance (context : Context) : F1Database{
            if (!::instance.isInitialized || instance == null) {
                instance = Room.databaseBuilder(context.applicationContext, F1Database::class.java,"notes_database")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return  instance

        }

    }
}
