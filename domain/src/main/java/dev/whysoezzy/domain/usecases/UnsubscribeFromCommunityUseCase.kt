package dev.whysoezzy.domain.usecases

import dev.whysoezzy.domain.repository.CommunitiesRepository

class UnsubscribeFromCommunityUseCase(
    private val communitiesRepository: CommunitiesRepository
) {
    suspend operator fun invoke(communityId: String): Result<Boolean> =
        communitiesRepository.unsubscribeFromCommunity(communityId)
}