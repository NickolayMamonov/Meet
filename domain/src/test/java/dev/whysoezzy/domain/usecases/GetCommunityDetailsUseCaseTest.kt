package dev.whysoezzy.domain.usecases

import dev.whysoezzy.domain.repository.CommunitiesRepositoryStub
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class GetCommunityDetailsUseCaseTest {
    // at the moment, name is being transferred to the screen, in the future I will redo it to id
    @Test
    fun `invoke should return community details with non-empty fields`() = runTest {
        val repository = CommunitiesRepositoryStub()
        val useCase = GetCommunityDetailsUseCase(repository)

        val result = useCase("Спорт").toList()
        val communityDetails = result[0]

        assertNotNull(communityDetails.id)
        assertNotNull(communityDetails.name)
        assertNotNull(communityDetails.description)
        assertTrue(communityDetails.events.isNotEmpty())
        communityDetails.events.forEach { event ->
            assertNotNull(event.id)
            assertNotNull(event.title)
            assertNotNull(event.subTitle)
            assertNotNull(event.icon)

        }
    }
}