package com.example.models.qualifyingresult

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SeasonQualifyingResultsWrapperModel(
    @SerializedName("MRData") @Expose var data: SeasonQualifyingResultsModel
)
