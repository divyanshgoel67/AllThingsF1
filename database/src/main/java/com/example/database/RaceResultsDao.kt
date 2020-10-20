package com.example.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.models.raceresult.DriverPositionResultsModel
import com.example.models.raceresult.RaceResultsModel

@Dao
interface RaceResultsDao {

    @Insert
    suspend fun insertSeasonRaceDetails(result: RaceResultsModel)

    @Query("SELECT * FROM season_race_results WHERE season = :season ORDER BY raceNumber")
    fun getSeasonRaceResults(season: String): LiveData<List<RaceResultsModel>>

    @Query("SELECT * FROM season_race_results WHERE season = :season AND raceNumber = :raceNumber")
    fun getRaceResult(season: String, raceNumber: Int): LiveData<RaceResultsModel>

    @Query("SELECT COUNT(*) FROM season_race_results WHERE season = :season")
    suspend fun getSeasonDataCount(season: String): Int

}
