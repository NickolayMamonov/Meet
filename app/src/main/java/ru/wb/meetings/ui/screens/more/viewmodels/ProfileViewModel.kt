package ru.wb.meetings.ui.screens.more.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.whysoezzy.domain.models.UserProfileModel
import dev.whysoezzy.domain.usecases.GetUserProfileUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.wb.meetings.ui.screens.more.states.ProfileScreenState

class ProfileViewModel(private val getUserProfileUseCase: GetUserProfileUseCase) : ViewModel() {
    private val _screenState = MutableStateFlow<ProfileScreenState>(ProfileScreenState.Loading)
    private val screenState: StateFlow<ProfileScreenState> = _screenState.asStateFlow()

    fun screenState() = screenState

    init {
        loadUserProfile()
    }

    private fun loadUserProfile() {
        viewModelScope.launch {
            try {
                getUserProfileUseCase().collect { userProfileModel: UserProfileModel ->
                    _screenState.value = ProfileScreenState.Content(userProfileModel)
                }
            } catch (e: Exception) {
                _screenState.value = ProfileScreenState.Error(e.message ?: "User profile not found")
            }

        }
    }
}