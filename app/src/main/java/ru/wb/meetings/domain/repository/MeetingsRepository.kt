package ru.wb.meetings.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.wb.meetings.domain.models.DetailsEventModel
import ru.wb.meetings.domain.models.MeetingEventModel


interface MeetingsRepository {
//    fun getActiveMeetings(): Flow<List<MeetingEventModel>>
    fun getAllMeetings(): Flow<List<MeetingEventModel>>
    fun getMeetingEvent(name: String): Flow<DetailsEventModel>
}