package dev.whysoezzy.ui.screens.events.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.whysoezzy.domain.models.DetailsEventModel
import dev.whysoezzy.domain.usecases.GetEventDetailsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import dev.whysoezzy.common.ScreenState

class DetailsEventViewModel(private val getEvent: GetEventDetailsUseCase, name: String) : ViewModel() {
    private val _screenState = MutableStateFlow<ScreenState<DetailsEventModel>>(ScreenState.Loading)
    private val screenState: StateFlow<ScreenState<DetailsEventModel>> = _screenState.asStateFlow()
    private val _showImageDialog = MutableStateFlow(false)
    private val showImageDialog: StateFlow<Boolean> = _showImageDialog.asStateFlow()
    private val _fullText = MutableStateFlow(false)
    private val fullText: StateFlow<Boolean> = _fullText.asStateFlow()
    private val _buttonPressed = MutableStateFlow(false)
    private val buttonPressed: StateFlow<Boolean> = _buttonPressed.asStateFlow()

    internal fun screenState() = screenState
    internal fun showImageDialog() = showImageDialog
    internal fun fullText() = fullText
    internal fun buttonPressed() = buttonPressed

    init {
        loadEventDetails(name)
    }

    private fun loadEventDetails(name: String) {
        viewModelScope.launch {
            _screenState.value = ScreenState.Loading
            try {
                getEvent(name).collectLatest { event ->
                    _screenState.value = ScreenState.Content(event)
                }
            } catch (e: Exception) {
                _screenState.value = ScreenState.Error(e.message ?: "Event details not found!")
            }
        }
    }

    internal fun setShowImageDialog(show: Boolean) {
        _showImageDialog.value = show
    }

    internal fun toggleFullText() {
        _fullText.value = !_fullText.value
    }

    internal fun setButtonPressed(pressed: Boolean) {
        _buttonPressed.value = pressed
    }
}