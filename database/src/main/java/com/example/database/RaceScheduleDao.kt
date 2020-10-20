package com.example.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.models.raceschedule.ScheduleEntityModel

@Dao
interface RaceScheduleDao {

    @Insert
    suspend fun insertScheduleList(schedule: List<ScheduleEntityModel>)

    @Query("SELECT * FROM race_schedule WHERE season = :season AND raceNumber > :raceNumber ORDER BY raceNumber")
    fun getScheduleFromRace(season: String, raceNumber: Int): LiveData<List<ScheduleEntityModel>>

    @Query("SELECT COUNT(*) FROM race_schedule WHERE season = :season")
    fun getTotalScheduledRaces(season: String): Int

}
