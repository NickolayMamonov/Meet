package ru.wb.meetings.ui.screens.more.states

import dev.whysoezzy.domain.models.UserProfileModel

sealed class ProfileScreenState {
    object Loading : ProfileScreenState()
    data class Error(val message: String) : ProfileScreenState()
    data class Content(val user: UserProfileModel) : ProfileScreenState()
}