package com.example.models.raceresult

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SeasonRaceResultsModel(
    @SerializedName("RaceTable") @Expose var raceTable: RaceTableModel
)
