package com.example.models.raceresult

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SeasonRaceResultsWrapperModel(
    @SerializedName("MRData") @Expose var data: SeasonRaceResultsModel
)
