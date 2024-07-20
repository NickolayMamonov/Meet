package ru.wb.meetings.ui.screens.more.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.wb.meetings.domain.models.MeetingEventModel
import ru.wb.meetings.domain.usecases.GetPassedMeetingsUseCase
import ru.wb.meetings.domain.usecases.GetPlannedMeetingsUseCase
import ru.wb.meetings.ui.screens.more.states.MyEventsScreenState

class MyEventsViewModel(
    private val getPassedMeetingsUseCase: GetPassedMeetingsUseCase,
    private val getPlannedMeetingsUseCase: GetPlannedMeetingsUseCase
) : ViewModel() {
    private val _screenState = MutableStateFlow<MyEventsScreenState>(MyEventsScreenState.Loading)
    val screenState: StateFlow<MyEventsScreenState> = _screenState.asStateFlow()

    private val _selectedTabIndex = MutableStateFlow(0)
    val selectedTabIndex: StateFlow<Int> = _selectedTabIndex

    private var _passedMeetingsList = MutableStateFlow<List<MeetingEventModel>>(emptyList())
    val passedMeetingsList: StateFlow<List<MeetingEventModel>> = _passedMeetingsList.asStateFlow()

    private var _plannedMeetingsList = MutableStateFlow<List<MeetingEventModel>>(emptyList())
    val plannedMeetingsList: StateFlow<List<MeetingEventModel>> = _plannedMeetingsList.asStateFlow()

    private val _events = MutableStateFlow<List<MeetingEventModel>>(emptyList())
    val events: StateFlow<List<MeetingEventModel>> = _events

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

    fun setSelectedTabIndex(index: Int) {
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
                    _screenState.value = MyEventsScreenState.Content(meetings)
                }
            }catch (e: Exception) {
                _screenState.value = MyEventsScreenState.Error(e.message ?: "Error")
            }
        }
    }
    private fun loadPlannedMeetings() {
        viewModelScope.launch {
            try {
                getPlannedMeetingsUseCase.invoke().collect { meetings ->
                    _plannedMeetingsList.update { meetings }
                    _screenState.value = MyEventsScreenState.Content(meetings)
                }
            } catch (e: Exception) {
                _screenState.value = MyEventsScreenState.Error(e.message ?: "Error")
            }
        }
    }
}