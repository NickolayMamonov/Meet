package dev.whysoezzy.domain.usecases

import kotlinx.coroutines.flow.Flow
import dev.whysoezzy.domain.models.UserProfileModel
import dev.whysoezzy.domain.repository.MoreRepository

class GetUserProfileUseCase(private val repository: MoreRepository) {
    operator fun invoke(): Flow<UserProfileModel> {
        return repository.getUserProfile()
    }
}