package com.example.models.raceresult

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "season_race_results")
class RaceResultsModel(
    var season: String,
    var raceNumber: Int,
    var raceName: String,
    var trackName: String,
    var country : String,
    var driverPositions : ArrayList<DriverPositionResultsModel>
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

