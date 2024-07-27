package dev.whysoezzy.ui.screens.more.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.whysoezzy.domain.models.MeetingEventModel
import dev.whysoezzy.domain.usecases.GetPassedMeetingsUseCase
import dev.whysoezzy.domain.usecases.GetPlannedMeetingsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import dev.whysoezzy.common.ScreenState

class MyEventsViewModel(
    private val getPassedMeetingsUseCase: GetPassedMeetingsUseCase,
    private val getPlannedMeetingsUseCase: GetPlannedMeetingsUseCase
) : ViewModel() {
    private val _screenState = MutableStateFlow<ScreenState<List<MeetingEventModel>>>(ScreenState.Loading)
    private val screenState: StateFlow<ScreenState<List<MeetingEventModel>>> = _screenState.asStateFlow()
    private val _selectedTabIndex = MutableStateFlow(0)
    private val selectedTabIndex: StateFlow<Int> = _selectedTabIndex.asStateFlow()
    private var _passedMeetingsList = MutableStateFlow<List<MeetingEventModel>>(emptyList())
    private val passedMeetingsList: StateFlow<List<MeetingEventModel>> =
        _passedMeetingsList.asStateFlow()
    private var _plannedMeetingsList = MutableStateFlow<List<MeetingEventModel>>(emptyList())
    private val plannedMeetingsList: StateFlow<List<MeetingEventModel>> =
        _plannedMeetingsList.asStateFlow()
    private val _events = MutableStateFlow<List<MeetingEventModel>>(emptyList())
    private val events: StateFlow<List<MeetingEventModel>> = _events.asStateFlow()

    fun screenState() = screenState
    fun selectedTabIndex() = selectedTabIndex
    fun passedMeetingsList() = passedMeetingsList
    fun plannedMeetingsList() = plannedMeetingsList
    fun events() = events

    val currentList: StateFlow<List<MeetingEventModel>> = combine(
        _selectedTabIndex, _plannedMeetingsList, _passedMeetingsList
    ) { selectedTabIndex, plannedMeetingList, passedMeetingsList ->
        when (selectedTabIndex) {
            0 -> plannedMeetingList
            else -> passedMeetingsList
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    init {
        loadPlannedMeetings()
        loadPassedMeetings()
    }

    internal fun setSelectedTabIndex(index: Int) {
        viewModelScope.launch {
            _selectedTabIndex.emit(index)
            when (index) {
                0 -> {
                    loadPlannedMeetings()
                }

                else -> {
                    loadPassedMeetings()
                }
            }
        }
    }

    private fun loadPassedMeetings() {
        viewModelScope.launch {
            try {
                getPassedMeetingsUseCase.invoke().collect { meetings ->
                    _passedMeetingsList.update { meetings }
                    _screenState.value = ScreenState.Content(meetings)
                }
            } catch (e: Exception) {
                _screenState.value = ScreenState.Error(e.message ?: "MyEventsList not found!")
            }
        }
    }

    private fun loadPlannedMeetings() {
        viewModelScope.launch {
            try {
                getPlannedMeetingsUseCase.invoke().collect { meetings ->
                    _plannedMeetingsList.update { meetings }
                    _screenState.value = ScreenState.Content(meetings)
                }
            } catch (e: Exception) {
                _screenState.value = ScreenState.Error(e.message ?: "Error")
            }
        }
    }
}