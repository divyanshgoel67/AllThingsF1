package com.example.models.common

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ConstructorModel(
    @SerializedName("constructorId") @Expose var constructorId: String,
    @SerializedName("name") @Expose var name: String,
    @SerializedName("nationality") @Expose var nationality: String
)
