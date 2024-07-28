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
import org.junit.jupiter.api.Assertions.*
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

@OptIn(ExperimentalCoroutinesApi::class)
class GetAllMeetingsUseCaseTest{
    private var useCase: GetAllMeetingsUseCase? = null

    @Before
    fun setUp() {
        startKoin { modules(usecasesModule, testRepositoryModule) }
        useCase = GetAllMeetingsUseCase(MeetingsRepositoryStub())
    }

    @After
    fun stop(){
        stopKoin()
        useCase = null
    }

    @Test
    fun `invoke should return non-empty list when there are meetings`() = runTest {
        val result = useCase?.let { it().toList() }
        val meetings = result?.first()
        meetings?.let { assertTrue(it.isNotEmpty()) }
    }



}