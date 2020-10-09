package com.example.database

import androidx.room.Dao
import androidx.room.Insert
import com.example.database.models.DriverPositionResultsModel

@Dao
interface RaceInfoDao {

    @Insert
    suspend fun insertRaceInfo(result: DriverPositionResultsModel)
}
