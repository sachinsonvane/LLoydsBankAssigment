package com.ss.lloydsbankpoc.data.models.api_models

import com.google.gson.annotations.SerializedName

data class Books(
    @SerializedName("title") var title: String? = null,
    @SerializedName("originalTitle") var originalTitle: String? = null,
    @SerializedName("releaseDate") var releaseDate: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("cover") var cover: String? = null
)