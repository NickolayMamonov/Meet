package dev.whysoezzy.domain.usecases

import dev.whysoezzy.domain.models.Meeting
import dev.whysoezzy.domain.repository.MeetingsRepository
import kotlinx.coroutines.flow.Flow

class GetUpcomingMeetingsUseCase(
    private val meetingsRepository: MeetingsRepository
) {
    suspend operator fun invoke(page: Int, pageSize: Int): Flow<List<Meeting>> =
        meetingsRepository.getUpcomingMeetings(page, pageSize)
}