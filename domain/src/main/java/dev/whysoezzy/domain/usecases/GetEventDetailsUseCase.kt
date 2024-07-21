package dev.whysoezzy.domain.usecases

import kotlinx.coroutines.flow.Flow
import dev.whysoezzy.domain.models.DetailsEventModel
import dev.whysoezzy.domain.repository.MeetingsRepository

class GetEventDetailsUseCase(private val repository: MeetingsRepository) {
    operator fun invoke(name: String): Flow<DetailsEventModel> {
        return repository.getMeetingEvent(name)
    }
}