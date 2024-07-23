package dev.whysoezzy.domain.models

data class CommunityDetailModel(
    val id: String,
    val name:String,
    val description:String,
    val events: List<MeetingEventModel>
)