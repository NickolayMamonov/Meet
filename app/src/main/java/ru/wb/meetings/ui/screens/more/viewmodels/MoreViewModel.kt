package ru.wb.meetings.ui.screens.more.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import dev.whysoezzy.domain.models.UserProfileModel
import dev.whysoezzy.domain.usecases.GetUserProfileUseCase
import ru.wb.meetings.ui.screens.more.states.MoreScreenState

class MoreViewModel(private val getUserProfileUseCase: GetUserProfileUseCase): ViewModel() {
    private val _screenState = MutableStateFlow<MoreScreenState>(MoreScreenState.Loading)
    val screenState: StateFlow<MoreScreenState> = _screenState.asStateFlow()

    init {
        loadUserProfile()
    }

    private fun loadUserProfile() {
        viewModelScope.launch {
            try{
                getUserProfileUseCase().collect { userProfileModel: UserProfileModel ->
                    _screenState.value = MoreScreenState.Content(userProfileModel)
                }
            }catch (e: Exception) {
                _screenState.value = MoreScreenState.Error(e.message ?: "User profile not found")
            }

        }
    }

}