package dev.whysoezzy.domain.usecases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import dev.whysoezzy.domain.models.MeetingEventModel
import dev.whysoezzy.domain.repository.MoreRepository

class GetPassedMeetingsUseCase(private val repository: MoreRepository) {
    operator fun invoke(): Flow<List<MeetingEventModel>> {
        return repository.getMeetings()
            .map { meetings ->
                meetings.filter { it.isEnded }

            }
    }
}