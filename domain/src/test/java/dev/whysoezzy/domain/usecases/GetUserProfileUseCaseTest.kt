package dev.whysoezzy.domain.usecases

import dev.whysoezzy.domain.repository.MoreRepositoryStub
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class GetUserProfileUseCaseTest {
    @Test
    fun `invoke should return user profile with non-empty fields`() = runTest {
        val repository = MoreRepositoryStub()
        val useCase = GetUserProfileUseCase(repository)

        val result = useCase().toList()
        val userProfile = result[0]

        assertNotNull(userProfile.id)
        assertNotNull(userProfile.name)
        assertNotNull(userProfile.phoneNumber)
        assertNotNull(userProfile.social)
    }
}