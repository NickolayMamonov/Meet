package ru.wb.meetings.ui.screens.events.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.whysoezzy.domain.models.DetailsEventModel
import dev.whysoezzy.domain.usecases.GetEventDetailsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ru.wb.meetings.ui.screens.events.states.DetailEventScreenState

class DetailsEventViewModel(private val getEvent: GetEventDetailsUseCase) : ViewModel() {

    private val _screenState = MutableStateFlow<DetailEventScreenState>(DetailEventScreenState.Loading)
    private val screenState: StateFlow<DetailEventScreenState> = _screenState.asStateFlow()

    fun screenState() = screenState

    private val _showImageDialog = MutableStateFlow(false)
    private val showImageDialog: StateFlow<Boolean> = _showImageDialog.asStateFlow()

    fun showImageDialog() = showImageDialog

    private val _fullText = MutableStateFlow(false)
    private val fullText: StateFlow<Boolean> = _fullText.asStateFlow()

    fun fullText() = fullText

    private val _buttonPressed = MutableStateFlow(false)
    private val buttonPressed: StateFlow<Boolean> = _buttonPressed.asStateFlow()

    fun buttonPressed() = buttonPressed

    fun loadEventDetails(name: String) {
        viewModelScope.launch {
            _screenState.value = DetailEventScreenState.Loading
            try {
                getEvent(name).collectLatest { event: DetailsEventModel ->
                    _screenState.value = DetailEventScreenState.Content(event)
                }
            } catch (e: Exception) {
                _screenState.value = DetailEventScreenState.Error(e.message ?: "Unknown error")
            }
        }
    }

    fun setShowImageDialog(show: Boolean) {
        _showImageDialog.value = show
    }

    fun toggleFullText() {
        _fullText.value = !_fullText.value
    }

    fun setButtonPressed(pressed: Boolean) {
        _buttonPressed.value = pressed
    }
}