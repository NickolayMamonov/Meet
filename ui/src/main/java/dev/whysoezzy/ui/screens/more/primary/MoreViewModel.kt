package dev.whysoezzy.ui.screens.more.primary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.whysoezzy.common.ScreenState
import dev.whysoezzy.domain.models.UserProfileModel
import dev.whysoezzy.domain.usecases.GetUserProfileUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class MoreViewModel(private val getUserProfileUseCase: GetUserProfileUseCase) :
    ViewModel() {
    private val _screenState = MutableStateFlow<ScreenState<UserProfileModel>>(ScreenState.Loading)
    private val screenState: StateFlow<ScreenState<UserProfileModel>> = _screenState.asStateFlow()

    fun screenState() = screenState

    init {
        loadUserProfile()
    }

    private fun loadUserProfile() {
        viewModelScope.launch {
            try {
                getUserProfileUseCase().collect { userProfileModel ->
                    _screenState.value = ScreenState.Content(userProfileModel)
                }
            } catch (e: Exception) {
                _screenState.value = ScreenState.Error(e.message ?: "User profile not found")
            }

        }
    }

}