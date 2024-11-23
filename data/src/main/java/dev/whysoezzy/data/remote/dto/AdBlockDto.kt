package dev.whysoezzy.data.remote.dto

import com.google.gson.annotations.SerializedName

data class AdBlockDto(
    @SerializedName("id") val id: String,
    @SerializedName("content") val content: String,
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("target_url") val targetUrl: String
)