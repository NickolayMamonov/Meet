package dev.whysoezzy.domain.usecases

import dev.whysoezzy.domain.di.testRepositoryModule
import dev.whysoezzy.domain.di.usecasesModule
import dev.whysoezzy.domain.repository.stub.MeetingsRepositoryStub
import dev.whysoezzy.domain.repository.stub.MoreRepositoryStub
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

@OptIn(ExperimentalCoroutinesApi::class)
class GetPassedMeetingsUseCaseTest() {
    private var useCase: GetPassedMeetingsUseCase? = null
    @Before
    fun setUp() {
        startKoin { modules(usecasesModule, testRepositoryModule) }
        useCase = GetPassedMeetingsUseCase(MoreRepositoryStub())
    }

    @After
    fun stop() {
        stopKoin()
        useCase = null
    }
    @Test
    fun `invoke should return non-null meeting ids`() = runTest {
        val result = useCase?.let { it().toList() }
        val meetings = result?.first()

        meetings?.forEach { meeting ->
            assertNotNull(meeting.id)
        }
    }

    @Test
    fun `invoke should return non-null meeting titles`() = runTest {
        val result = useCase?.let { it().toList() }
        val meetings = result?.first()

        meetings?.forEach { meeting ->
            assertNotNull(meeting.title)
        }
    }

    @Test
    fun `invoke should return non-null meeting subTitles`() = runTest {
        val result = useCase?.let { it().toList() }
        val meetings = result?.first()

        meetings?.forEach { meeting ->
            assertNotNull(meeting.subTitle)
        }
    }

    @Test
    fun `invoke should return non-null meeting icons`() = runTest {
        val result = useCase?.let { it().toList() }
        val meetings = result?.first()

        meetings?.forEach { meeting ->
            assertNotNull(meeting.icon)
        }
    }

    @Test
    fun `invoke should return meetings that are ended`() = runTest {
        val result = useCase?.let { it().toList() }
        val meetings = result?.first()

        meetings?.forEach { meeting ->
            assertTrue(meeting.isEnded)
        }
    }

}