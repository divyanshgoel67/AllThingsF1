package com.example.models.raceresult

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RaceTableModel(
    @SerializedName("season") @Expose var season: Int,
    @SerializedName("round") @Expose var round: Int,
    @SerializedName("Races") @Expose var races: List<RaceDetailModel>
)
