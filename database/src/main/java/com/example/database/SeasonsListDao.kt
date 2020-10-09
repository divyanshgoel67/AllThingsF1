package com.example.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.models.seasons.SeasonsDetailModel

@Dao
interface SeasonsListDao {

    @Insert
    suspend fun insertSeasonsList(result: List<SeasonsDetailModel>)

    @Query("SELECT * FROM seasons_list ORDER BY SEASON DESC LIMIT 1")
    fun getCurrentSeason(): LiveData<SeasonsDetailModel>

    @Query("SELECT * FROM seasons_list WHERE season = :season")
    fun getSeasonInfo(season: String): LiveData<SeasonsDetailModel>

    @Query("SELECT * FROM seasons_list ORDER BY season")
    fun getAllSeasons(): LiveData<List<SeasonsDetailModel>>

    @Query("SELECT COUNT(*) FROM seasons_list")
    suspend fun getSeasonsCount(): Int

}
