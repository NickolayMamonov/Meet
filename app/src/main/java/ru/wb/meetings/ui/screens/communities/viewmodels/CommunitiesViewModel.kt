package ru.wb.meetings.ui.screens.communities.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.whysoezzy.domain.models.CommunityEventModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import dev.whysoezzy.domain.usecases.GetCommunityUseCase
import ru.wb.meetings.ui.screens.communities.states.CommunitiesScreenState

class CommunitiesViewModel(private val getCommunityUseCase: GetCommunityUseCase): ViewModel() {
    private val _screenState = MutableStateFlow<CommunitiesScreenState>(CommunitiesScreenState.Loading)
    val screenState: StateFlow<CommunitiesScreenState> = _screenState

    init {
        loadCommunities()
    }

    private fun loadCommunities() {
        viewModelScope.launch {
            _screenState.value = CommunitiesScreenState.Loading
            try {
                getCommunityUseCase.invoke().collect { communitiesList: List<CommunityEventModel> ->
                    _screenState.value = CommunitiesScreenState.Content(communitiesList)
                }
            } catch (e: Exception) {
                _screenState.value = CommunitiesScreenState.Error(e.message ?: "Unknown error")
            }
        }
    }

}