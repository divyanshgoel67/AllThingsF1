package com.example.models.standings

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SeasonStandingsModel(
    @SerializedName("StandingsTable") @Expose var standingsTable: StandingsTableModel
)
