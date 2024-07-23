package dev.whysoezzy.domain.repository

import kotlinx.coroutines.flow.Flow
import dev.whysoezzy.domain.models.CommunityDetailModel
import dev.whysoezzy.domain.models.CommunityEventModel

interface CommunitiesRepository {
    fun getCommunities(): Flow<List<CommunityEventModel>>
    fun getCommunity(name: String): Flow<CommunityDetailModel>
}