package ru.wb.meetings.ui.screens.communities.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.whysoezzy.domain.models.CommunityDetailModel
import dev.whysoezzy.domain.usecases.GetCommunityDetailsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ru.wb.meetings.ui.screens.communities.states.DetailsCommunityScreenState


class DetailsCommunityViewModel(private val getCommunityDetailsUseCase: GetCommunityDetailsUseCase) : ViewModel() {
    private val _screenState = MutableStateFlow<DetailsCommunityScreenState>(
        DetailsCommunityScreenState.Loading)
    val screenState: StateFlow<DetailsCommunityScreenState> = _screenState

    private val _fullText = MutableStateFlow(false)
    val fullText: StateFlow<Boolean> = _fullText.asStateFlow()

    fun loadCommunityDetails(name: String) {
        viewModelScope.launch {
            _screenState.value = DetailsCommunityScreenState.Loading
            try {
                getCommunityDetailsUseCase(name).collectLatest { details: CommunityDetailModel ->
                    _screenState.value = DetailsCommunityScreenState.Content(details)
                }
            } catch (e: Exception) {
                _screenState.value = DetailsCommunityScreenState.Error(e.message ?: "Unknown error")
            }
        }
    }

    fun toggleFullText() {
        _fullText.value = !_fullText.value
    }
}