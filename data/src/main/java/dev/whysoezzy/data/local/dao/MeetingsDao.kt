package dev.whysoezzy.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.whysoezzy.data.local.entity.MeetingEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MeetingsDao {
    @Query("SELECT * FROM meetings")
    fun getAllMeetings(): Flow<List<MeetingEntity>>

    @Query("SELECT * FROM meetings WHERE id = :meetingId")
    fun getMeetingById(meetingId: String): Flow<MeetingEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeetings(meetings: List<MeetingEntity>)

    @Query("DELETE FROM meetings WHERE lastUpdated < :timestamp")
    suspend fun deleteOldMeetings(timestamp: Long)
}