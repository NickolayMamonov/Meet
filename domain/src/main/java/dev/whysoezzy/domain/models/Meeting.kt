package dev.whysoezzy.domain.models

import java.time.LocalDateTime
import java.util.Date

data class Meeting(
    val id: String,
    val title: String,
    val description: String,
    val dateTime: Date,
    val location: Location,
    val organizerId: String,
    val communityId: String,
    val tags: List<Tag>,
    val participantsCount: Int,
    val maxParticipants: Int,
    val imageUrl: String
)

