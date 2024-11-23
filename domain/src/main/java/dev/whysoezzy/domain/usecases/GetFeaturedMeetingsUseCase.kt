package dev.whysoezzy.domain.usecases

import dev.whysoezzy.domain.models.Meeting
import dev.whysoezzy.domain.repository.MeetingsRepository
import kotlinx.coroutines.flow.Flow

class GetFeaturedMeetingsUseCase(
    private val meetingsRepository: MeetingsRepository
) {
    suspend operator fun invoke(): Flow<List<Meeting>> =
        meetingsRepository.getFeaturedMeetings()
}