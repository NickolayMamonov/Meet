package ru.wb.meetings.ui.screens.events.states

import dev.whysoezzy.domain.models.DetailsEventModel

sealed class DetailEventScreenState {
    object Loading : DetailEventScreenState()
    data class Error(val message: String) : DetailEventScreenState()
    data class Content(val event: DetailsEventModel) : DetailEventScreenState()
}