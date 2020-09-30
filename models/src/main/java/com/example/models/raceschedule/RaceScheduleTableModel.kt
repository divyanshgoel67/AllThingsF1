package com.example.models.raceschedule

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RaceScheduleTableModel(
    @SerializedName("season") @Expose var season: Int,
    @SerializedName("round") @Expose var round: Int,
    @SerializedName("Races") @Expose var Races: List<RaceScheduleDetailModel>
)
