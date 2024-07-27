package dev.whysoezzy.domain.usecases

import dev.whysoezzy.domain.repository.MoreRepositoryStub
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotNull

@OptIn(ExperimentalCoroutinesApi::class)
class GetPlannedMeetingsUseCaseTest {
    @Test
    fun `invoke should return list of passed meetings with non-empty fields`() = runTest {
        val repository = MoreRepositoryStub()
        val useCase = GetPlannedMeetingsUseCase(repository)

        val result = useCase().toList()
        val meetings = result[0]

        meetings.forEach { meeting ->
            assertNotNull(meeting.id)
            assertNotNull(meeting.title)
            assertNotNull(meeting.subTitle)
            assertNotNull(meeting.icon)
            assertFalse(meeting.isEnded)
        }
    }
}