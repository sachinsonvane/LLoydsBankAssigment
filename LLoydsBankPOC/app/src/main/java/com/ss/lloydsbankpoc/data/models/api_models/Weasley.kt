package com.ss.lloydsbankpoc.data.models.api_models

import com.google.gson.annotations.SerializedName

data class Weasley(
    @SerializedName("fullName") var fullName: String,
    @SerializedName("nickname") var nickname: String,
    @SerializedName("hogwartsHouse") var hogwartsHouse: String,
    @SerializedName("interpretedBy") var interpretedBy: String,
    @SerializedName("image") var image: String,
    @SerializedName("birthdate") var birthdate: String
)