package dev.whysoezzy.ui.screens.communities.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.whysoezzy.domain.models.CommunityEventModel
import dev.whysoezzy.domain.usecases.GetCommunityUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import dev.whysoezzy.common.ScreenState

class CommunitiesViewModel(private val getCommunityUseCase: GetCommunityUseCase) : ViewModel() {
    private val _screenState = MutableStateFlow<ScreenState<List<CommunityEventModel>>>(ScreenState.Loading)
    private val screenState: StateFlow<ScreenState<List<CommunityEventModel>>> = _screenState.asStateFlow()

    fun screenState() = screenState

    init {
        loadCommunities()
    }

    fun loadCommunities() {
        viewModelScope.launch {
            _screenState.value = ScreenState.Loading
            try {
                getCommunityUseCase.invoke().collect { communitiesList: List<CommunityEventModel> ->
                    _screenState.value = ScreenState.Content(communitiesList)
                }
            } catch (e: Exception) {
                _screenState.value = ScreenState.Error(e.message ?: "Communities not found!")
            }
        }
    }

}