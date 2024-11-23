package dev.whysoezzy.domain.usecases

import dev.whysoezzy.domain.repository.CommunitiesRepository

class SubscribeToCommunityUseCase(
    private val communitiesRepository: CommunitiesRepository
) {
    suspend operator fun invoke(communityId: String): Result<Boolean> =
        communitiesRepository.subscribeToCommunity(communityId)
}