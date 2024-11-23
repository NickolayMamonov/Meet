package dev.whysoezzy.domain.usecases

import dev.whysoezzy.domain.models.Meeting
import dev.whysoezzy.domain.repository.MeetingsRepository
import kotlinx.coroutines.flow.Flow

class SearchMeetingsUseCase(
    private val meetingsRepository: MeetingsRepository
) {
    suspend operator fun invoke(query: String): Flow<List<Meeting>> =
        meetingsRepository.searchMeetings(query)
}