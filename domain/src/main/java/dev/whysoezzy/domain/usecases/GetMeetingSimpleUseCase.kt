package dev.whysoezzy.domain.usecases

import dev.whysoezzy.domain.models.Meeting
import dev.whysoezzy.domain.repository.MeetingsRepository
import dev.whysoezzy.domain.utils.MeetingType
import dev.whysoezzy.domain.utils.SimpleUseCase
import kotlinx.coroutines.flow.Flow

interface GetMeetingSimpleUseCase : SimpleUseCase<MeetingType, Flow<List<Meeting>>> {
    override suspend fun execute(data: MeetingType): Flow<List<Meeting>>
}

class GetMeetingSimpleUseCaseImpl(
    private val repository: MeetingsRepository
) : GetMeetingSimpleUseCase {
    override suspend fun execute(data: MeetingType): Flow<List<Meeting>> = when (data) {
        is MeetingType.Popular -> repository.getPopularMeetings()
        is MeetingType.Featured -> repository.getFeaturedMeetings()
        is MeetingType.All -> repository.getAllMeetings()
    }
}