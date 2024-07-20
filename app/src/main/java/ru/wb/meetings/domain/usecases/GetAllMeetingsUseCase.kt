package ru.wb.meetings.domain.usecases

import kotlinx.coroutines.flow.Flow
import ru.wb.meetings.domain.models.MeetingEventModel
import ru.wb.meetings.domain.repository.MeetingsRepository

class GetAllMeetingsUseCase(private val meetingsRepository: MeetingsRepository) {
    operator fun invoke(): Flow<List<MeetingEventModel>> {
        return  meetingsRepository.getAllMeetings()
    }

}