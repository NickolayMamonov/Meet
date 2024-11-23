package dev.whysoezzy.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meetings")
data class MeetingEntity(
    @PrimaryKey val id: String,
    val title: String,
    val description: String,
    val dateTime: String,
    val locationAddress: String,
    val locationLatitude: Double,
    val locationLongitude: Double,
    val organizerId: String,
    val communityId: String,
    val participantsCount: Int,
    val maxParticipants: Int,
    val imageUrl: String,
    val lastUpdated: Long = System.currentTimeMillis()
)