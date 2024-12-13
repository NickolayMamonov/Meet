package dev.whysoezzy.domain.usecases

import dev.whysoezzy.domain.repository.stub.MeetingsRepositoryStub
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class GetAllMeetingsSimpleUseCaseTest {
    private var useCase: GetAllMeetingsUseCase? = null

    @Before
    fun setUp() {
        useCase = GetAllMeetingsUseCase(MeetingsRepositoryStub())
    }

    @After
    fun stop() {
        useCase = null
    }

    @Test
    fun `invoke should return non-empty list when there are meetings`() = runTest {
        val result = useCase?.invoke()?.toList()
        val meetings = result?.first()
        meetings?.let { assertTrue(it.isNotEmpty()) }
    }

}