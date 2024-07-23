package ru.wb.meetings.ui.screens.events.states

import dev.whysoezzy.domain.models.MeetingEventModel

sealed class EventsScreenState {
    object Loading : EventsScreenState()
    data class Error(val message: String) : EventsScreenState()
    data class Content(val events: List<MeetingEventModel>) : EventsScreenState()
}