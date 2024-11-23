package dev.whysoezzy.domain.repository

import kotlinx.coroutines.flow.Flow
import dev.whysoezzy.domain.models.Meeting
import dev.whysoezzy.domain.utils.Result


interface MeetingsRepository {
    suspend fun getFeaturedMeetings(): Flow<List<Meeting>>
    suspend fun getUpcomingMeetings(page: Int, pageSize: Int): Flow<List<Meeting>>
    suspend fun getMeetingsByTags(tags: List<String>, page: Int, pageSize: Int): Flow<List<Meeting>>
    suspend fun searchMeetings(query: String): Flow<List<Meeting>>
    suspend fun getMeetingDetails(meetingId: String): Flow<Meeting>
    suspend fun joinMeeting(meetingId: String): Result<Boolean>
    suspend fun leaveMeeting(meetingId: String): Result<Boolean>
}