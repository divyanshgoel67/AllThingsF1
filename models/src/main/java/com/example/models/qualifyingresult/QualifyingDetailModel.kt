package com.example.models.qualifyingresult

import com.example.models.common.CircuitModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class QualifyingDetailModel(
    @SerializedName("season") @Expose var season: Int,
    @SerializedName("round") @Expose var round: Int,
    @SerializedName("raceName") @Expose var raceName: String,
    @SerializedName("Circuit") @Expose var circuit: CircuitModel,
    @SerializedName("date") @Expose var date: String,
    @SerializedName("QualifyingResults") @Expose var results: List<FinalQualifyingGridModel>
)
