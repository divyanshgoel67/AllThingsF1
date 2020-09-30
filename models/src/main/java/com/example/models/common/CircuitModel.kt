package com.example.models.common

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CircuitModel(
    @SerializedName("circuitId") @Expose var circuitId: String,
    @SerializedName("circuitName") @Expose var circuitName: String,
    @SerializedName("Location") @Expose var location: CircuitLocationModel
)

data class CircuitLocationModel(
    @SerializedName("locality") @Expose var locality: String,
    @SerializedName("country") @Expose var country: String
)
