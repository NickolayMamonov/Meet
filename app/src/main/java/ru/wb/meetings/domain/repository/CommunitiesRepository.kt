package ru.wb.meetings.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.wb.meetings.domain.models.CommunityDetailModel
import ru.wb.meetings.domain.models.CommunityEventModel

interface CommunitiesRepository {
    fun getCommunities(): Flow<List<CommunityEventModel>>
    fun getCommunity(name: String): Flow<CommunityDetailModel>
}