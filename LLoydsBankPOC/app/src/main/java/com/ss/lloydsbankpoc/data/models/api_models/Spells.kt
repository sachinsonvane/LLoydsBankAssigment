package com.ss.lloydsbankpoc.data.models.api_models

import com.google.gson.annotations.SerializedName

data class Spells(
    @SerializedName("spell") var spell: String,
    @SerializedName("use") var use: String
)