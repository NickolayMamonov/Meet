package dev.whysoezzy.domain.usecases

import kotlinx.coroutines.flow.Flow
import dev.whysoezzy.domain.models.CommunityEventModel
import dev.whysoezzy.domain.models.MeetingEventModel
import dev.whysoezzy.domain.repository.CommunitiesRepository

class GetCommunityUseCase(private val repository: CommunitiesRepository) {
    operator fun invoke(): Flow<List<CommunityEventModel>> {
        return repository.getCommunities()
    }
}