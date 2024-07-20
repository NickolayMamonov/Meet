package ru.wb.meetings.ui.screens.communities.states

import dev.whysoezzy.domain.models.CommunityEventModel

sealed class CommunitiesScreenState {
    object Loading : CommunitiesScreenState()
    data class Error(val message: String) : CommunitiesScreenState()
    data class Content(val communities: List<CommunityEventModel>) : CommunitiesScreenState()
}