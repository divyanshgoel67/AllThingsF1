package com.example.models.seasons

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SeasonsTableModel(
    @SerializedName("SeasonTable") @Expose var seasonsTable: SeasonsListModel
)
