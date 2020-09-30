package com.example.models.raceresult

import com.example.models.common.ConstructorModel
import com.example.models.common.DriverModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FinalGridPositionModel(
    @SerializedName("number") @Expose var number: Int,
    @SerializedName("position") @Expose var position: Int,
    @SerializedName("points") @Expose var points: Int,
    @SerializedName("Driver") @Expose var driver: DriverModel,
    @SerializedName("Constructor") @Expose var constructor: ConstructorModel,
    @SerializedName("laps") @Expose var laps: Int,
    @SerializedName("status") @Expose var status: String,
    @SerializedName("Time") @Expose var time: TimeModel,
    @SerializedName("FastestLap") @Expose var fastestLap: FastestLapModel,
    @SerializedName("AverageSpeed") @Expose var averageSpeed: AverageSpeedModel
)

data class TimeModel(
    @SerializedName("time") @Expose var time: String
)

data class FastestLapModel(
    @SerializedName("lap") @Expose var lap: Int,
    @SerializedName("Time") @Expose var time: TimeModel

)

data class AverageSpeedModel(
    @SerializedName("units") @Expose var units: String,
    @SerializedName("speed") @Expose var speed: Double
)
