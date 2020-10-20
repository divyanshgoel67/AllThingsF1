package com.example.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.models.raceresult.RaceResultsModel
import com.example.models.raceschedule.ScheduleEntityModel
import com.example.models.seasons.SeasonsDetailModel
import javax.inject.Singleton

@Database(
    entities = [RaceResultsModel::class, SeasonsDetailModel::class, ScheduleEntityModel::class],
    version = 3
)
@Singleton
@TypeConverters(Converter::class)
abstract class F1Database : RoomDatabase() {

    abstract fun raceResultsDao() : RaceResultsDao

    abstract fun seasonsListDao() : SeasonsListDao

    abstract fun scheduleDao(): RaceScheduleDao
}
