package dev.whysoezzy.ui.screens.communities.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.whysoezzy.common.ScreenState
import dev.whysoezzy.domain.models.CommunityDetailModel
import dev.whysoezzy.domain.usecases.GetCommunityDetailsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class DetailsCommunityViewModel(
    private val getCommunityDetailsUseCase: GetCommunityDetailsUseCase,
    name: String
) : ViewModel() {
    private val _screenState =
        MutableStateFlow<ScreenState<CommunityDetailModel>>(ScreenState.Loading)
    private val screenState: StateFlow<ScreenState<CommunityDetailModel>> =
        _screenState.asStateFlow()
    private val _fullText = MutableStateFlow(false)
    private val fullText: StateFlow<Boolean> = _fullText.asStateFlow()

    internal fun screenState() = screenState
    internal fun fullText() = fullText

    init {
        loadCommunityDetails(name)
    }

    private fun loadCommunityDetails(name: String) {
        viewModelScope.launch {
            _screenState.value = ScreenState.Loading
            try {
                getCommunityDetailsUseCase(name).collectLatest { details ->
                    _screenState.value = ScreenState.Content(details)
                }
            } catch (e: Exception) {
                _screenState.value = ScreenState.Error(e.message ?: "Details Community not found!")
            }
        }
    }

    internal fun toggleFullText() {
        _fullText.value = !_fullText.value
    }
}