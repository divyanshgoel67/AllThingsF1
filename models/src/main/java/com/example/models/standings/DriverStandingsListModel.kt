package com.example.models.standings

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DriverStandingsListModel(
    @SerializedName("Constructors") @Expose var constructors: List<DriverStandingsDetailModel>
)
