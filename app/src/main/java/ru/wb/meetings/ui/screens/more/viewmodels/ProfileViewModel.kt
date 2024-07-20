package ru.wb.meetings.ui.screens.more.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.wb.meetings.domain.models.UserProfileModel
import ru.wb.meetings.domain.usecases.GetUserProfileUseCase
import ru.wb.meetings.ui.screens.more.states.MoreScreenState
import ru.wb.meetings.ui.screens.more.states.ProfileScreenState

class ProfileViewModel(private val getUserProfileUseCase: GetUserProfileUseCase): ViewModel() {
    private val _screenState = MutableStateFlow<ProfileScreenState>(ProfileScreenState.Loading)
    val screenState: StateFlow<ProfileScreenState> = _screenState.asStateFlow()

    init {
        loadUserProfile()
    }

    private fun loadUserProfile() {
        viewModelScope.launch {
            try{
                getUserProfileUseCase().collect { userProfileModel ->
                    _screenState.value = ProfileScreenState.Content(userProfileModel)
                }
            }catch (e: Exception) {
                _screenState.value = ProfileScreenState.Error(e.message ?: "User profile not found")
            }

        }
    }
}