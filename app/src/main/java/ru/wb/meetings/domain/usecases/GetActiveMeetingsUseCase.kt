package ru.wb.meetings.domain.usecases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.wb.meetings.domain.models.MeetingEventModel
import ru.wb.meetings.domain.repository.MeetingsRepository

class GetActiveMeetingsUseCase(private val meetingsRepository: MeetingsRepository) {
    operator fun invoke(): Flow<List<MeetingEventModel>> {
        return meetingsRepository.getAllMeetings()
            .map { meetings -> meetings.filter { !it.isEnded } }
    }
}