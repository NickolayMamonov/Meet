package dev.whysoezzy.domain.usecases

import dev.whysoezzy.domain.repository.MeetingsRepositoryStub
import dev.whysoezzy.domain.repository.MoreRepositoryStub
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class GetActiveMeetingsUseCaseTest {
    @Test
    fun `invoke should return only active meetings from backend`() = runTest {
        val repository = MeetingsRepositoryStub()
        val useCase = GetActiveMeetingsUseCase(meetingsRepository = repository)

        val result = useCase().toList()
        val activeMeetings = result[0]

        activeMeetings.forEach { meeting ->
            assertNotNull(meeting.id)
            assertNotNull(meeting.title)
            assertNotNull(meeting.subTitle)
            assertNotNull(meeting.icon)
            assertFalse(meeting.isEnded)
        }
    }





}

