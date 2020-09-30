package com.example.models.qualifyingresult

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SeasonQualifyingResultsModel(
    @SerializedName("RaceTable") @Expose var raceTable: QualifyingTableModel
)
