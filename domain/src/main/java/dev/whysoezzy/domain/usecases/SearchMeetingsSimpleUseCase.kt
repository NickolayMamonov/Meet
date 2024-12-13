package dev.whysoezzy.domain.usecases

import dev.whysoezzy.domain.models.Meeting
import dev.whysoezzy.domain.repository.MeetingsRepository
import dev.whysoezzy.domain.utils.SimpleUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

interface SearchMeetingsSimpleUseCase : SimpleUseCase<String, Flow<List<Meeting>>> {
    override suspend fun execute(data: String): Flow<List<Meeting>>
}

class SearchMeetingsSimpleUseCaseImpl(
    private val repository: MeetingsRepository,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

) : SearchMeetingsSimpleUseCase {
    override suspend fun execute(data: String): Flow<List<Meeting>> {
        return repository.searchMeetings(data)
            .map { meetings ->
                meetings.filter { meeting ->
                    meeting.title.contains(data, ignoreCase = true)
                    meeting.description.contains(data, ignoreCase = true)
                    meeting.tags.any { it.name.contains(data, ignoreCase = true) }
                }
            }.flowOn(ioDispatcher)
    }
}