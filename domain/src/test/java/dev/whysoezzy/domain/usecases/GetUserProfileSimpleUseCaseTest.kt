package dev.whysoezzy.domain.usecases

import dev.whysoezzy.domain.repository.stub.MoreRepositoryStub
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertNotNull

@OptIn(ExperimentalCoroutinesApi::class)
class GetUserProfileSimpleUseCaseTest {
    private var useCase: GetUserProfileUseCase? = null

    @Before
    fun setUp() {
        useCase = GetUserProfileUseCase(MoreRepositoryStub())
    }

    @After
    fun stop() {
        useCase = null
    }

    @Test
    fun `invoke should return non-null user name`() = runTest {
        val result = useCase?.invoke()?.toList()
        val userProfile = result?.first()

        assertNotNull(userProfile?.name)
    }

    @Test
    fun `invoke should return non-null user phone number`() = runTest {
        val result = useCase?.invoke()?.toList()
        val userProfile = result?.first()

        assertNotNull(userProfile?.phoneNumber)
    }

    @Test
    fun `invoke should return non-null user social`() = runTest {
        val result = useCase?.invoke()?.toList()
        val userProfile = result?.first()

        assertNotNull(userProfile?.social)
    }
}