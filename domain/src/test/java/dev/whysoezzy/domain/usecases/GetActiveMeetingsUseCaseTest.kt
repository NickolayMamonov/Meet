package dev.whysoezzy.domain.usecases

import dev.whysoezzy.domain.di.testRepositoryModule
import dev.whysoezzy.domain.di.usecasesModule
import dev.whysoezzy.domain.repository.stub.MeetingsRepositoryStub
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotNull
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

@OptIn(ExperimentalCoroutinesApi::class)
class GetActiveMeetingsUseCaseTest {
    private var useCase: GetActiveMeetingsUseCase? = null

    @Before
    fun setUp() {
        startKoin { modules(usecasesModule, testRepositoryModule) }
        useCase = GetActiveMeetingsUseCase(MeetingsRepositoryStub())
    }

    @After
    fun stop(){
        stopKoin()
        useCase = null
    }

    @Test
    fun `invoke should return non-null meeting ids`() = runTest {
        val result = useCase?.let { it().toList() }
        val activeMeetings = result?.first()

        activeMeetings?.forEach { meeting ->
            assertNotNull(meeting.id)
        }
    }

    @Test
    fun `invoke should return non-null meeting titles`() = runTest {
        val result = useCase?.let { it().toList() }
        val activeMeetings = result?.first()

        activeMeetings?.forEach { meeting ->
            assertNotNull(meeting.title)
        }
    }

    @Test
    fun `invoke should return non-null meeting subTitles`() = runTest {
        val result = useCase?.let { it().toList() }
        val activeMeetings = result?.first()

        activeMeetings?.forEach { meeting ->
            assertNotNull(meeting.subTitle)
        }
    }

    @Test
    fun `invoke should return non-null meeting icons`() = runTest {
        val result = useCase?.let { it().toList() }
        val activeMeetings = result?.first()

        activeMeetings?.forEach { meeting ->
            assertNotNull(meeting.icon)
        }
    }

    @Test
    fun `invoke should return meetings that are not ended`() = runTest {
        val result = useCase?.let { it().toList() }
        val activeMeetings = result?.first()

        activeMeetings?.forEach { meeting ->
            assertFalse(meeting.isEnded)
        }
    }





}

