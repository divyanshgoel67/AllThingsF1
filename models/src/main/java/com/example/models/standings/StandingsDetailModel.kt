package com.example.models.standings

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class StandingsDetailModel(
    @SerializedName("season") @Expose var season: Int,
    @SerializedName("round") @Expose var round: Int,
    @SerializedName("DriverStandings") @Expose var driverStandings: DriverStandingsListModel
)
