package com.example.models.raceresult

import com.example.models.common.CircuitModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RaceDetailModel(
    @SerializedName("season") @Expose var season: String,
    @SerializedName("round") @Expose var round: Int,
    @SerializedName("raceName") @Expose var raceName: String,
    @SerializedName("Circuit") @Expose var circuit: CircuitModel,
    @SerializedName("date") @Expose var date: String,
    @SerializedName("Results") @Expose var results: List<FinalGridPositionModel>


)
