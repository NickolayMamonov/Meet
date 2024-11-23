package dev.whysoezzy.data.remote.dto

import com.google.gson.annotations.SerializedName

data class TagDto(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String
)