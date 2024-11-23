package dev.whysoezzy.domain.usecases

import dev.whysoezzy.domain.models.Meeting
import dev.whysoezzy.domain.repository.MeetingsRepository
import kotlinx.coroutines.flow.Flow

class GetMeetingsByTagsUseCase(
    private val meetingsRepository: MeetingsRepository
) {
    suspend operator fun invoke(tags: List<String>, page: Int, pageSize: Int): Flow<List<Meeting>> =
        meetingsRepository.getMeetingsByTags(tags, page, pageSize)
}