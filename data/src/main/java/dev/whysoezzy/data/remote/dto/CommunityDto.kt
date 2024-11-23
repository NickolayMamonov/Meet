package dev.whysoezzy.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CommunityDto(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("subscribers_count") val subscribersCount: Int,
    @SerializedName("is_subscribed") val isSubscribed: Boolean
)