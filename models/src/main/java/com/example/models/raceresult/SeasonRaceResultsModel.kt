package com.example.models.raceresult

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SeasonRaceResultsModel(
    @SerializedName("limit") @Expose var limit : String,
    @SerializedName("RaceTable") @Expose var raceTable: RaceTableModel
)
