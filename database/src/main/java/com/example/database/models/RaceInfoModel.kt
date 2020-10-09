package com.example.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "race_info")
class RaceInfoModel(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var season : String,
    var raceNumber : Int,
    var gpName : String,
    var gpCircuitName : String,
    var gpDate : String
)
