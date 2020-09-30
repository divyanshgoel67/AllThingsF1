package com.example.models.qualifyingresult

import com.example.models.common.ConstructorModel
import com.example.models.common.DriverModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FinalQualifyingGridModel(
    @SerializedName("number") @Expose var number: Int,
    @SerializedName("position") @Expose var position: Int,
    @SerializedName("Driver") @Expose var driver: DriverModel,
    @SerializedName("Constructor") @Expose var constructor: ConstructorModel,
    @SerializedName("Q1") @Expose var q1: String,
    @SerializedName("Q2") @Expose var q2: String,
    @SerializedName("Q3") @Expose var q3: String
)
