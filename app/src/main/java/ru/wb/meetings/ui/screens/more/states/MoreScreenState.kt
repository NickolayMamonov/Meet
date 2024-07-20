package ru.wb.meetings.ui.screens.more.states

import ru.wb.meetings.domain.models.UserProfileModel

sealed class MoreScreenState{
    object Loading : MoreScreenState()
    data class Content(val user: UserProfileModel) : MoreScreenState()
    data class Error(val message: String) : MoreScreenState()
}