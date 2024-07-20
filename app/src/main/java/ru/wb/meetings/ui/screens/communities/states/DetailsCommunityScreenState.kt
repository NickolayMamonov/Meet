package ru.wb.meetings.ui.screens.communities.states

import ru.wb.meetings.domain.models.CommunityDetailModel

sealed class DetailsCommunityScreenState {
    object Loading : DetailsCommunityScreenState()
    data class Content(val communityDetails: CommunityDetailModel) : DetailsCommunityScreenState()
    data class Error(val message: String) : DetailsCommunityScreenState()
}