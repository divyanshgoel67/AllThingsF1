package com.example.models.seasons

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SeasonsListWrapperModel(
    @SerializedName("MRData") @Expose var data: SeasonsTableModel
)


