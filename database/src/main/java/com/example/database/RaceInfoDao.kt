package com.example.database

import androidx.room.Dao
import androidx.room.Insert
import com.example.models.raceresult.DriverPositionResultsModel

@Dao
interface RaceInfoDao {

    @Insert
    suspend fun insertRaceInfo(result: DriverPositionResultsModel)
}
