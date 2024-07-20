package ru.wb.meetings.domain.usecases

import kotlinx.coroutines.flow.Flow
import ru.wb.meetings.domain.models.UserProfileModel
import ru.wb.meetings.domain.repository.MoreRepository

class GetUserProfileUseCase(private val repository: MoreRepository) {
    operator fun invoke(): Flow<UserProfileModel> {
        return repository.getUserProfile()
    }
}