package dev.whysoezzy.domain.repository

import dev.whysoezzy.domain.models.Community
import kotlinx.coroutines.flow.Flow

interface CommunitiesRepository {
    suspend fun getAllCommunities(): Flow<List<Community>>
    suspend fun getFeaturedCommunities(): Flow<List<Community>>
    suspend fun subscribeToCommunity(communityId: String): Result<Boolean>
    suspend fun unsubscribeFromCommunity(communityId: String): Result<Boolean>
    suspend fun getCommunityDetails(communityId: String): Flow<Community>
}