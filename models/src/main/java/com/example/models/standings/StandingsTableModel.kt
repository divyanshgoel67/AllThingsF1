package com.example.models.standings

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class StandingsTableModel(
    @SerializedName("season") @Expose var season: Int,
    @SerializedName("StandingsLists") @Expose var standingsLists: StandingsDetailModel
)
