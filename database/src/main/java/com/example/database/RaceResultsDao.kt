package com.example.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.database.models.DriverPositionResultsModel
import com.example.database.models.RaceResultsModel

@Dao
interface RaceResultsDao {

    @Insert
    suspend fun insertSeasonRaceDetails(result: RaceResultsModel)

    @Query("SELECT * FROM season_race_results WHERE season = :season ORDER BY raceNumber")
    fun getSeasonRaceResults(season: String): LiveData<List<RaceResultsModel>>

    @Query("SELECT * FROM season_race_results WHERE season = :season AND raceNumber = :raceNumber")
    fun getRaceResult(season: String, raceNumber: Int): LiveData<List<DriverPositionResultsModel>>

    @Query("SELECT COUNT(*) FROM season_race_results WHERE season = :season")
    suspend fun getSeasonDataCount(season: String): Int

//    @Delete
//    suspend fun deleteNote(note : NotesModel)
//
//    @Query("SELECT * FROM notes_content WHERE createdAt = :createdAt")
//    fun getNote(createdAt : Long) : LiveData<NotesModel>
//
//    @Query("SELECT * FROM notes_content where editedAt = :time")
//    fun getNoteByTime(time : Long) : NotesModel
//
//    @Query("SELECT COUNT(createdAt) FROM notes_content WHERE createdAt = :createdAt")
//    suspend fun getNotesCount(createdAt : Long) : Int
//
//    @Query("SELECT COUNT(*) FROM notes_content")
//    suspend fun getTotalCount() : Int
}
