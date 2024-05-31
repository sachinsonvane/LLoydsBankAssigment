package com.ss.lloydsbankpoc.data.models.api_models

import com.google.gson.annotations.SerializedName

data class Books(
    @SerializedName("title") var title: String,
    @SerializedName("originalTitle") var originalTitle: String,
    @SerializedName("releaseDate") var releaseDate: String,
    @SerializedName("description") var description: String,
    @SerializedName("cover") var cover: String
)