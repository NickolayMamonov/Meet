package dev.whysoezzy.domain.repository

import kotlinx.coroutines.flow.Flow
import dev.whysoezzy.domain.models.DetailsEventModel
import dev.whysoezzy.domain.models.MeetingEventModel


interface MeetingsRepository {
    fun getAllMeetings(): Flow<List<MeetingEventModel>>
    fun getMeetingEvent(name: String): Flow<DetailsEventModel>
}