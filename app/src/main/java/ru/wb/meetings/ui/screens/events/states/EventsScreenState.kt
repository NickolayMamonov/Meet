package ru.wb.meetings.ui.screens.events.states

import ru.wb.meetings.domain.models.MeetingEventModel

sealed class EventsScreenState {
    object Loading : EventsScreenState()
    data class Error(val message: String) : EventsScreenState()
    data class Content(val events: List<MeetingEventModel>) : EventsScreenState()
}