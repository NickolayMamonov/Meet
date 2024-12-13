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
class GetCommunityDetailsSimpleUseCaseTest {
    // at the moment, name is being transferred to the screen, in the future I will redo it to id
    private var useCase: GetCommunityDetailsUseCase? = null

    @Before
    fun setUp() {
        useCase = GetCommunityDetailsUseCase(CommunitiesRepositoryStub())
    }

    @After
    fun stop() {
        useCase = null
    }

    @Test
    fun `invoke should return non-null community id`() = runTest {
        val result = useCase?.invoke("Спорт")?.toList()
        val communityDetails = result?.first()

        assertNotNull(communityDetails?.id)
    }

    @Test
    fun `invoke should return non-null community name`() = runTest {
        val result = useCase?.invoke("Спорт")?.toList()
        val communityDetails = result?.first()

        assertNotNull(communityDetails?.name)
    }

    @Test
    fun `invoke should return non-null community description`() = runTest {
        val result = useCase?.invoke("Спорт")?.toList()
        val communityDetails = result?.first()

        assertNotNull(communityDetails?.description)
    }

    @Test
    fun `invoke should return non-empty community events`() = runTest {
        val result = useCase?.invoke("Спорт")?.toList()
        val communityDetails = result?.first()

        communityDetails?.events?.let { assertTrue(it.isNotEmpty()) }
    }

    @Test
    fun `invoke should return non-null event ids`() = runTest {
        val result = useCase?.invoke("Спорт")?.toList()
        val communityDetails = result?.first()

        communityDetails?.events?.forEach { event ->
            assertNotNull(event.id)
        }
    }

    @Test
    fun `invoke should return non-null event titles`() = runTest {
        val result = useCase?.invoke("Спорт")?.toList()
        val communityDetails = result?.first()

        communityDetails?.events?.forEach { event ->
            assertNotNull(event.title)
        }
    }

    @Test
    fun `invoke should return non-null event subTitles`() = runTest {
        val result = useCase?.invoke("Спорт")?.toList()
        val communityDetails = result?.first()

        communityDetails?.events?.forEach { event ->
            assertNotNull(event.subTitle)
        }
    }

    @Test
    fun `invoke should return non-null event icons`() = runTest {
        val result = useCase?.invoke("Спорт")?.toList()
        val communityDetails = result?.first()

        communityDetails?.events?.forEach { event ->
            assertNotNull(event.icon)
        }
    }

}