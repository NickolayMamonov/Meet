package dev.whysoezzy.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meeting_tags_cross_ref")
data class MeetingTagCrossRef(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val meetingId: String,
    val tagId: String
)