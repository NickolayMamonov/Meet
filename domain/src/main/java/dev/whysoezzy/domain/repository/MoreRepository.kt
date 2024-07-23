package dev.whysoezzy.domain.repository

import kotlinx.coroutines.flow.Flow
import dev.whysoezzy.domain.models.MeetingEventModel
import dev.whysoezzy.domain.models.UserProfileModel

interface MoreRepository {
    fun getUserProfile(): Flow<UserProfileModel>
    fun getMeetings(): Flow<List<MeetingEventModel>>
}