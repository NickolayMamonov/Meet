package ru.wb.meetings.domain.usecases

import kotlinx.coroutines.flow.Flow
import ru.wb.meetings.domain.models.CommunityDetailModel
import ru.wb.meetings.domain.repository.CommunitiesRepository

class GetCommunityDetailsUseCase(private val repository: CommunitiesRepository) {
    operator fun invoke(name: String): Flow<CommunityDetailModel> {
        return repository.getCommunity(name)
    }
}