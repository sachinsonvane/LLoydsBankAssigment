package com.ss.lloydsbankpoc.data.models.api_models

import com.google.gson.annotations.SerializedName

data class Weasley(
    @SerializedName("fullName") var fullName: String? = null,
    @SerializedName("nickname") var nickname: String? = null,
    @SerializedName("hogwartsHouse") var hogwartsHouse: String? = null,
    @SerializedName("interpretedBy") var interpretedBy: String? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("birthdate") var birthdate: String? = null
)