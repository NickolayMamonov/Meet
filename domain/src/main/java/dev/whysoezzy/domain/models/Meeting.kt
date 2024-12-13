package dev.whysoezzy.domain.models

import java.util.Date

data class Meeting(
    val id: Long,
    val title: String,
    val description: String,
    val date: Date,
    val location: Location,
    val tags: List<Tag>,
    val host: User,
    val community: Community,
    val maxParticipants: Int,
    val participants: List<User>,
    val imageUrl: String
)

