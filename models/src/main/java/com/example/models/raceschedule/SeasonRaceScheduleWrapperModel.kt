package com.example.models.raceschedule

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SeasonRaceScheduleWrapperModel(
    @SerializedName("MRData") @Expose var data: SeasonRaceScheduleModel
)
