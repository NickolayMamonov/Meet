package ru.wb.meetings.domain.usecases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.wb.meetings.domain.models.MeetingEventModel
import ru.wb.meetings.domain.repository.MoreRepository

class GetPassedMeetingsUseCase(private val repository: MoreRepository) {
    operator fun invoke(): Flow<List<MeetingEventModel>> {
        return repository.getMeetings()
            .map { meetings ->
                meetings.filter { it.isEnded }

            }
    }
}