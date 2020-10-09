package com.example.models.seasons

import androidx.room.Entity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "seasons_list")
data class SeasonsDetailModel (
    @SerializedName("season") @Expose var season: String,
    @SerializedName("url") @Expose var url: String
)
