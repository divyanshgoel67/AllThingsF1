package com.example.models.qualifyingresult

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class QualifyingTableModel(
    @SerializedName("season") @Expose var season: Int,
    @SerializedName("round") @Expose var round: Int,
    @SerializedName("Races") @Expose var Races: List<QualifyingDetailModel>
)
