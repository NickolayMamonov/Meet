package dev.whysoezzy.domain.usecases

import dev.whysoezzy.domain.models.Community
import dev.whysoezzy.domain.repository.CommunitiesRepository
import kotlinx.coroutines.flow.Flow

class GetCommunitiesUseCase(
    private val communitiesRepository: CommunitiesRepository
) {
    suspend operator fun invoke(): Flow<List<Community>> =
        communitiesRepository.getFeaturedCommunities()
}