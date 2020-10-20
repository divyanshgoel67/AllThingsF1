package com.example.models.raceschedule

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "race_schedule")
data class ScheduleEntityModel(
    var season: String,
    var raceNumber: Int,
    var raceName: String,
    var trackName: String,
    var country: String,
    var date: String
) {
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}
