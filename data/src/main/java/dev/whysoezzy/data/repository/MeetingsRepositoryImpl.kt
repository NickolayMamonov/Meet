package dev.whysoezzy.data.repository

import dev.whysoezzy.data.local.dao.MeetingsDao
import dev.whysoezzy.data.remote.api.MeetingsApi
import dev.whysoezzy.domain.models.AdBlock
import dev.whysoezzy.domain.models.Community
import dev.whysoezzy.domain.models.Meeting
import dev.whysoezzy.domain.repository.MeetingsRepository
import dev.whysoezzy.domain.repository.stub.Mock
import dev.whysoezzy.domain.utils.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


internal class MeetingsRepositoryImpl(
    private val api: MeetingsApi,
    private val dao: MeetingsDao,
    private val mock: Mock,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : MeetingsRepository {

    override suspend fun getPopularMeetings(): Flow<List<Meeting>> {
        return flow {
            emit(mock.getListOfEvents())
        }.flowOn(ioDispatcher)
    }

    override suspend fun getFeaturedMeetings(): Flow<List<Meeting>> {
        return flow {
            emit(mock.getListOfEvents())
        }.flowOn(ioDispatcher)
    }

    override suspend fun getAllMeetings(): Flow<List<Meeting>> {
        return flow {
            emit(mock.getListOfEvents())
        }.flowOn(ioDispatcher)
    }

    override suspend fun searchMeetings(query: String): Flow<List<Meeting>> {
        TODO("Not yet implemented")
    }

    override suspend fun getMeetingDetails(meetingId: Long): Flow<Meeting> {
        return flow {
            emit(mock.mockMeeting)
        }.flowOn(ioDispatcher)
    }

    override suspend fun getCommunitiesByJob(job: String): Flow<List<Community>> {
        TODO("Not yet implemented")
    }

    override suspend fun joinCommunity(communityId: Long): Result<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun leaveCommunity(communityId: Long): Result<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun joinMeeting(meetingId: Long): Result<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun leaveMeeting(meetingId: Long): Result<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun getAdBlock(advertiseId: Long): Flow<AdBlock> {
        TODO("Not yet implemented")
    }
//    private val cacheTimeout = 30L * 60 * 1000 // 30 minutes

//    override suspend fun getFeaturedMeetings(): Flow<List<Meeting>> = flow {
//        dao.getAllMeetings()
//            .map { entities -> entities.map { it.toDomain() } }
//            .collect { cachedMeetings -> emit(cachedMeetings) }
//
//        try {
//            withContext(ioDispatcher) {
//                val remoteMeetings = api.getFeaturedMeetings()
//                val entities = remoteMeetings.map { dto ->
//                    MeetingEntity(
//                        id = dto.id,
//                        title = dto.title,
//                        description = dto.description,
//                        dateTime = dto.dateTime,
//                        locationAddress = dto.location.address,
//                        locationLatitude = dto.location.latitude,
//                        locationLongitude = dto.location.longitude,
//                        organizerId = dto.organizerId,
//                        communityId = dto.communityId,
//                        participantsCount = dto.participantsCount,
//                        maxParticipants = dto.maxParticipants,
//                        imageUrl = dto.imageUrl
//                    )
//                }
//                dao.insertMeetings(entities)
//                dao.deleteOldMeetings(System.currentTimeMillis() - cacheTimeout)
//            }
//        } catch (e: Exception) {
//            emit(emptyList<Meeting>())
//        }
//    }.flowOn(ioDispatcher)

//    override suspend fun getUpcomingMeetings(page: Int, pageSize: Int): Flow<List<Meeting>> = flow {
//        dao.getAllMeetings()
//            .map { entities ->
//                entities
//                    .filter { entity ->
//                        DateTimeUtils.parseDate(entity.dateTime).after(Date())
//                    }
//                    .sortedBy { it.dateTime }
//                    .drop(page * pageSize)
//                    .take(pageSize)
//                    .map { it.toDomain() }
//            }
//            .collect { cachedMeetings -> emit(cachedMeetings) }
//
//        try {
//            val remoteMeetings = api.getUpcomingMeetings(page, pageSize)
//            val entities = remoteMeetings.map { it.toDomain().toEntity() }
//            dao.insertMeetings(entities)
//        } catch (e: Exception) {
//            Timber.e("MeetingsRepository", "Error fetching upcoming meetings", e)
//        }
//    }.flowOn(ioDispatcher)
//
//    override suspend fun getMeetingsByTags(
//        tags: List<String>,
//        page: Int,
//        pageSize: Int
//    ): Flow<List<Meeting>> = flow {
//        try {
//            val remoteMeetings = api.getMeetingsByTags(tags, page, pageSize)
//            val entities = remoteMeetings.map { it.toDomain().toEntity() }
//            dao.insertMeetings(entities)
//            emit(remoteMeetings.map { it.toDomain() })
//        } catch (e: Exception) {
//            Timber.e("MeetingsRepository", "Error fetching meetings by tags", e)
//            emit(emptyList())
//        }
//    }.flowOn(ioDispatcher)
//    override suspend fun getMeetingDetails(meetingId: String): Flow<Meeting> = flow {
//        dao.getMeetingById(meetingId)
//            .map { entity -> entity.toDomain() }
//            .collect { meeting -> emit(meeting) }
//
//        try {
//            val remoteMeeting = api.getMeetingDetails(meetingId)
//            val entity = remoteMeeting.toDomain().toEntity()
//            dao.insertMeetings(listOf(entity))
//        } catch (e: Exception) {
//            Timber.e("MeetingsRepository", "Error fetching meeting details", e)
//        }
//    }.flowOn(ioDispatcher)

//    override suspend fun searchMeetings(query: String): Flow<List<Meeting>> = flow {
//        try {
//            val searchResults = api.searchMeetings(query)
//            emit(searchResults.map { it.toDomain() })
//        } catch (e: Exception) {
//            Timber.e("MeetingsRepository", "Error searching meetings", e)
//            emit(emptyList())
//        }
//    }.flowOn(ioDispatcher)


//    override suspend fun joinMeeting(meetingId: Long): Result<Boolean> =
//        try {
//            val result = api.joinMeeting(meetingId)
//            if (result) {
//                Result.Success(true)
//            } else {
//                Result.Error(Exception("Failed to join meeting"))
//            }
//        } catch (e: Exception) {
//            Timber.e("MeetingsRepository", "Error joining meeting", e)
//            Result.Error(e)
//        }
//
//    override suspend fun leaveMeeting(meetingId: Long): Result<Boolean> =
//        try {
//            val result = api.leaveMeeting(meetingId)
//            if (result) {
//                Result.Success(true)
//            } else {
//                Result.Error(Exception("Failed to leave meeting"))
//            }
//        } catch (e: Exception) {
//            Timber.e("MeetingsRepository", "Error leaving meeting", e)
//            Result.Error(e)
//        }


}