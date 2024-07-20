package ru.wb.meetings.domain.usecases

import kotlinx.coroutines.flow.Flow
import ru.wb.meetings.domain.models.DetailsEventModel
import ru.wb.meetings.domain.repository.MeetingsRepository

class GetEventDetailsUseCase(private val repository: MeetingsRepository) {
    operator fun invoke(name: String): Flow<DetailsEventModel> {
        return repository.getMeetingEvent(name)
    }
}