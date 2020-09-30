package com.example.models.common

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DriverModel(
    @SerializedName("driverId") @Expose var driverId: String,
    @SerializedName("givenName") @Expose var givenName: String,
    @SerializedName("familyName") @Expose var familyName: String,
    @SerializedName("nationality") @Expose var nationality: String
)
