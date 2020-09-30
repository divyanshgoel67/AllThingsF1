package com.example.models.standings

import com.example.models.common.ConstructorModel
import com.example.models.common.DriverModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DriverStandingsDetailModel(
    @SerializedName("position") @Expose var position: Int,
    @SerializedName("points") @Expose var points: Int,
    @SerializedName("wins") @Expose var wins: Int,
    @SerializedName("Driver") @Expose var driver: DriverModel,
    @SerializedName("Constructors") @Expose var constructors: List<ConstructorModel>
)
