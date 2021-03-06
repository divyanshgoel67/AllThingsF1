package com.example.models.seasons

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SeasonsListModel (
    @SerializedName("Seasons") @Expose var seasons: List<SeasonsDetailModel>
)

