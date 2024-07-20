package ru.wb.meetings.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.wb.meetings.domain.models.MeetingEventModel
import ru.wb.meetings.domain.models.UserProfileModel

interface MoreRepository {
    fun getUserProfile(): Flow<UserProfileModel>
    fun getMeetings(): Flow<List<MeetingEventModel>>
//    fun getPlannedMeetings(): Flow<List<MeetingEventModel>>

}