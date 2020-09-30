package com.example.models.standings

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SeasonStandingsWrapperModel(
    @SerializedName("MRData") @Expose var data: SeasonStandingsModel
)
