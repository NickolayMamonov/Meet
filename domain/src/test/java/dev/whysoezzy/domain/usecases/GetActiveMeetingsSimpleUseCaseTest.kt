package dev.whysoezzy.domain.usecases

import dev.whysoezzy.domain.repository.stub.MeetingsRepositoryStub
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotNull

@OptIn(ExperimentalCoroutinesApi::class)
class GetActiveMeetingsSimpleUseCaseTest {
    private var useCase: GetActiveMeetingsUseCase? = null

    @Before
    fun setUp() {
        useCase = GetActiveMeetingsUseCase(MeetingsRepositoryStub())
    }

    @After
    fun stop(){
        useCase = null
    }

    @Test
    fun `invoke should return non-null meeting ids`() = runTest {
        val result = useCase?.invoke()?.toList()
        val activeMeetings = result?.first()

        activeMeetings?.forEach { meeting ->
            assertNotNull(meeting.id)
        }
    }

    @Test
    fun `invoke should return non-null meeting titles`() = runTest {
        val result = useCase?.invoke()?.toList()
        val activeMeetings = result?.first()

        activeMeetings?.forEach { meeting ->
            assertNotNull(meeting.title)
        }
    }

    @Test
    fun `invoke should return non-null meeting subTitles`() = runTest {
        val result = useCase?.invoke()?.toList()
        val activeMeetings = result?.first()

        activeMeetings?.forEach { meeting ->
            assertNotNull(meeting.subTitle)
        }
    }

    @Test
    fun `invoke should return non-null meeting icons`() = runTest {
        val result = useCase?.invoke()?.toList()
        val activeMeetings = result?.first()

        activeMeetings?.forEach { meeting ->
            assertNotNull(meeting.icon)
        }
    }

    @Test
    fun `invoke should return meetings that are not ended`() = runTest {
        val result = useCase?.invoke()?.toList()
        val activeMeetings = result?.first()

        activeMeetings?.forEach { meeting ->
            assertFalse(meeting.isEnded)
        }
    }
}

