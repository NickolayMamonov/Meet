package dev.whysoezzy.domain.usecases

import dev.whysoezzy.domain.repository.MeetingsRepositoryStub
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

@OptIn(ExperimentalCoroutinesApi::class)
class GetEventDetailsUseCaseTest{
    // at the moment, name is being transferred to the screen, in the future I will redo it to id
    @Test
    fun `invoke should return event details for existing event`() = runTest {
        val repository = MeetingsRepositoryStub()
        val useCase = GetEventDetailsUseCase(repository)

        val result = useCase("Developer Meeting").toList()
        val eventDetails = result[0]

        assertNotNull(eventDetails.id)
        assertNotNull(eventDetails.title)
        assertNotNull(eventDetails.description)
        assertNotNull(eventDetails.tags)
        assertNotNull(eventDetails.location)
    }


}