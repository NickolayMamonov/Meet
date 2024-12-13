package dev.whysoezzy.domain.usecases

import dev.whysoezzy.domain.repository.stub.CommunitiesRepositoryStub
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class GetCommunitySimpleUseCaseTest {
    private var useCase: GetCommunityUseCase? = null

    @Before
    fun setUp() {
        useCase = GetCommunityUseCase(CommunitiesRepositoryStub())
    }

    @After
    fun stop() {
        useCase = null
    }

    @Test
    fun `invoke should return non-empty list of communities`() = runTest {
        val result = useCase?.invoke()?.toList()
        val communities = result?.first()

        communities?.let { assertTrue(it.isNotEmpty()) }
    }

    @Test
    fun `invoke should return communities with non-null ids`() = runTest {
        val result = useCase?.invoke()?.toList()
        val communities = result?.first()

        communities?.forEach { community ->
            assertNotNull(community.id)
        }
    }

    @Test
    fun `invoke should return communities with non-null titles`() = runTest {
        val result = useCase?.invoke()?.toList()
        val communities = result?.first()

        communities?.forEach { community ->
            assertNotNull(community.title)
        }
    }

    @Test
    fun `invoke should return communities with non-null avatars`() = runTest {
        val result = useCase?.invoke()?.toList()
        val communities = result?.first()

        communities?.forEach { community ->
            assertNotNull(community.avatar)
        }
    }

    @Test
    fun `invoke should return communities with quantity greater than zero`() = runTest {
        val result = useCase?.invoke()?.toList()
        val communities = result?.first()

        communities?.forEach { community ->
            assertTrue(community.quantity > 0)
        }
    }
}