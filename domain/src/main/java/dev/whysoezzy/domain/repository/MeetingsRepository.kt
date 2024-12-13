package dev.whysoezzy.domain.repository

import dev.whysoezzy.domain.models.AdBlock
import dev.whysoezzy.domain.models.Community
import kotlinx.coroutines.flow.Flow
import dev.whysoezzy.domain.models.Meeting
import dev.whysoezzy.domain.utils.Result


interface MeetingsRepository {
    suspend fun getPopularMeetings(): Flow<List<Meeting>>
    suspend fun getFeaturedMeetings(): Flow<List<Meeting>>
    suspend fun getAllMeetings():Flow<List<Meeting>>

    suspend fun searchMeetings(query: String): Flow<List<Meeting>>
    suspend fun getMeetingDetails(meetingId: Long): Flow<Meeting>

    suspend fun getCommunitiesByJob(job: String): Flow<List<Community>>
    suspend fun joinCommunity(communityId: Long): Result<Boolean>
    suspend fun leaveCommunity(communityId: Long): Result<Boolean>

    suspend fun joinMeeting(meetingId: Long): Result<Boolean>
    suspend fun leaveMeeting(meetingId: Long): Result<Boolean>

    suspend fun getAdBlock(advertiseId:Long): Flow<AdBlock>
}