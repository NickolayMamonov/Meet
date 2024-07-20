package dev.whysoezzy.domain.usecases

import kotlinx.coroutines.flow.Flow
import dev.whysoezzy.domain.models.CommunityDetailModel
import dev.whysoezzy.domain.repository.CommunitiesRepository

class GetCommunityDetailsUseCase(private val repository: CommunitiesRepository) {
    operator fun invoke(name: String): Flow<CommunityDetailModel> {
        return repository.getCommunity(name)
    }
}