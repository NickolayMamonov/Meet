package dev.whysoezzy.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "communities")
data class CommunityEntity(
    @PrimaryKey val id: String,
    val name: String,
    val description: String,
    val imageUrl: String,
    val subscribersCount: Int,
    val isSubscribed: Boolean,
    val lastUpdated: Long = System.currentTimeMillis()
)