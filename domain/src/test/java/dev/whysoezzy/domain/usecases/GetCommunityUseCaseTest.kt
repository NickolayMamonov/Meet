package dev.whysoezzy.domain.usecases

import dev.whysoezzy.domain.repository.CommunitiesRepositoryStub
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class GetCommunityUseCaseTest {
    @Test
    fun `invoke should return list of community events with non-empty fields`() = runTest {
        val repository = CommunitiesRepositoryStub()
        val useCase = GetCommunityUseCase(repository)

        val result = useCase().toList()
        val communities = result[0]

        assertTrue(communities.isNotEmpty())
        communities.forEach { community ->
            assertNotNull(community.id)
            assertNotNull(community.title)
            assertNotNull(community.avatar)
            assertTrue(community.quantity > 0)
        }
    }
}