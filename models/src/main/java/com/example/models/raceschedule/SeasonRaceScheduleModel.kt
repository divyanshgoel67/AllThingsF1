package com.example.models.raceschedule

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SeasonRaceScheduleModel(
    @SerializedName("RaceTable") @Expose var raceTable: RaceScheduleTableModel
)
