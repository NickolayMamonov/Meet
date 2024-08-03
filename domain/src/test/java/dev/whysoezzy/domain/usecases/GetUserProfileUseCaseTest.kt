package dev.whysoezzy.domain.usecases

import dev.whysoezzy.domain.di.testRepositoryModule
import dev.whysoezzy.domain.di.usecasesModule
import dev.whysoezzy.domain.repository.stub.MoreRepositoryStub
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertNotNull
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

@OptIn(ExperimentalCoroutinesApi::class)
class GetUserProfileUseCaseTest {
    private var useCase: GetUserProfileUseCase? = null
    @Before
    fun setUp() {
        startKoin { modules(usecasesModule, testRepositoryModule) }
        useCase = GetUserProfileUseCase(MoreRepositoryStub())
    }

    @After
    fun stop() {
        stopKoin()
        useCase = null
    }
    @Test
    fun `invoke should return non-null user name`() = runTest {
        val result = useCase?.let { it().toList() }
        val userProfile = result?.first()

        assertNotNull(userProfile?.name)
    }

    @Test
    fun `invoke should return non-null user phone number`() = runTest {
        val result = useCase?.let { it().toList() }
        val userProfile = result?.first()

        assertNotNull(userProfile?.phoneNumber)
    }

    @Test
    fun `invoke should return non-null user social`() = runTest {
        val result = useCase?.let { it().toList() }
        val userProfile = result?.first()

        assertNotNull(userProfile?.social)
    }
}