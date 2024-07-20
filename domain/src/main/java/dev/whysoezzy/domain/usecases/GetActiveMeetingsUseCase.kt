package dev.whysoezzy.domain.usecases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import dev.whysoezzy.domain.models.MeetingEventModel
import dev.whysoezzy.domain.repository.MeetingsRepository

class GetActiveMeetingsUseCase(private val meetingsRepository: MeetingsRepository) {
    operator fun invoke(): Flow<List<MeetingEventModel>> {
        return meetingsRepository.getAllMeetings()
            .map { meetings -> meetings.filter { !it.isEnded } }
    }
}