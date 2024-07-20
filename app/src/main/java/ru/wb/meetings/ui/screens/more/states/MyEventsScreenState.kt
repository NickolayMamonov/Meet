package ru.wb.meetings.ui.screens.more.states

import ru.wb.meetings.domain.models.MeetingEventModel

sealed class MyEventsScreenState {
    object Loading : MyEventsScreenState()
    data class Error(val message: String) : MyEventsScreenState()
    data class Content(val events: List<MeetingEventModel>) : MyEventsScreenState()
}