package dev.whysoezzy.domain.usecases

import dev.whysoezzy.domain.repository.MeetingsRepositoryStub
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

@OptIn(ExperimentalCoroutinesApi::class)
class GetAllMeetingsUseCaseTest{

    @Test
    fun `invoke should return non-empty list when there are meetings`() = runTest {
        val repository = MeetingsRepositoryStub()
        val useCase = GetAllMeetingsUseCase(meetingsRepository = repository)

        val result = useCase().toList()
        val meetings = result[0]

        assertTrue(meetings.isNotEmpty())
    }



}