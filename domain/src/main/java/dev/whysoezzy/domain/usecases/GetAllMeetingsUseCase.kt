package dev.whysoezzy.domain.usecases

import kotlinx.coroutines.flow.Flow
import dev.whysoezzy.domain.models.MeetingEventModel
import dev.whysoezzy.domain.repository.MeetingsRepository

class GetAllMeetingsUseCase(private val meetingsRepository: MeetingsRepository) {
    operator fun invoke(): Flow<List<MeetingEventModel>> {
        return  meetingsRepository.getAllMeetings()
    }

}