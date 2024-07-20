package ru.wb.meetings.domain.usecases

import kotlinx.coroutines.flow.Flow
import ru.wb.meetings.domain.models.CommunityEventModel
import ru.wb.meetings.domain.models.MeetingEventModel
import ru.wb.meetings.domain.repository.CommunitiesRepository

class GetCommunityUseCase(private val repository: CommunitiesRepository) {
    operator fun invoke(): Flow<List<CommunityEventModel>> {
        return  repository.getCommunities()
    }
}