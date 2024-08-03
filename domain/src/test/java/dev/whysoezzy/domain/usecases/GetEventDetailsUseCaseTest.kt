package dev.whysoezzy.domain.usecases

import dev.whysoezzy.domain.di.testRepositoryModule
import dev.whysoezzy.domain.di.usecasesModule
import dev.whysoezzy.domain.repository.stub.CommunitiesRepositoryStub
import dev.whysoezzy.domain.repository.stub.MeetingsRepositoryStub
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

@OptIn(ExperimentalCoroutinesApi::class)
class GetEventDetailsUseCaseTest{
    // at the moment, name is being transferred to the screen, in the future I will redo it to id
    private var useCase: GetEventDetailsUseCase? = null
    @Before
    fun setUp() {
        startKoin { modules(usecasesModule, testRepositoryModule) }
        useCase = GetEventDetailsUseCase(MeetingsRepositoryStub())
    }

    @After
    fun stop() {
        stopKoin()
        useCase = null
    }
    @Test
    fun `invoke should return non-null event id`() = runTest {
        val result = useCase?.let { it("Developer Meeting").toList() }
        val eventDetails = result?.first()

        assertNotNull(eventDetails?.id)
    }

    @Test
    fun `invoke should return non-null event title`() = runTest {
        val result = useCase?.let { it("Developer Meeting").toList() }
        val eventDetails = result?.first()

        assertNotNull(eventDetails?.title)
    }

    @Test
    fun `invoke should return non-null event description`() = runTest {
        val result = useCase?.let { it("Developer Meeting").toList() }
        val eventDetails = result?.first()

        assertNotNull(eventDetails?.description)
    }

    @Test
    fun `invoke should return non-null event tags`() = runTest {
        val result = useCase?.let { it("Developer Meeting").toList() }
        val eventDetails = result?.first()

        assertNotNull(eventDetails?.tags)
    }

    @Test
    fun `invoke should return non-null event location`() = runTest {
        val result = useCase?.let { it("Developer Meeting").toList() }
        val eventDetails = result?.first()

        assertNotNull(eventDetails?.location)
    }

}