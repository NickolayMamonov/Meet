package dev.whysoezzy.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MeetingDto(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("date_time") val dateTime: String,
    @SerializedName("location") val location: LocationDto,
    @SerializedName("organizer_id") val organizerId: String,
    @SerializedName("community_id") val communityId: String,
    @SerializedName("tags") val tags: List<TagDto>,
    @SerializedName("participants_count") val participantsCount: Int,
    @SerializedName("max_participants") val maxParticipants: Int,
    @SerializedName("image_url") val imageUrl: String
)