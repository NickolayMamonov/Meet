package ru.wb.meetings.ui.screens.events.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.whysoezzy.domain.models.MeetingEventModel
import dev.whysoezzy.domain.usecases.GetActiveMeetingsUseCase
import dev.whysoezzy.domain.usecases.GetAllMeetingsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.wb.meetings.ui.screens.events.states.EventsScreenState

class EventsViewModel(
    private val getAllMeetings: GetAllMeetingsUseCase,
    private val getActiveMeetings: GetActiveMeetingsUseCase
) : ViewModel() {
    private val _screenState = MutableStateFlow<EventsScreenState>(EventsScreenState.Loading)
    val screenState: StateFlow<EventsScreenState> = _screenState.asStateFlow()

    private val _selectedTabIndex = MutableStateFlow(0)
    val selectedTabIndex: StateFlow<Int> = _selectedTabIndex

    private var _allMeetingsList = MutableStateFlow<List<MeetingEventModel>>(emptyList())
    val allMeetingsList: StateFlow<List<MeetingEventModel>> = _allMeetingsList.asStateFlow()

    private var _activeMeetingsList = MutableStateFlow<List<MeetingEventModel>>(emptyList())
    val activeMeetingsList: StateFlow<List<MeetingEventModel>> = _activeMeetingsList.asStateFlow()

    val currentList: StateFlow<List<MeetingEventModel>> = combine(
        _selectedTabIndex, _allMeetingsList, _activeMeetingsList
    ) { selectedTabIndex, allMeetingsList, activeMeetingsList ->
        when (selectedTabIndex) {
            0 -> allMeetingsList
            else -> activeMeetingsList
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    init {
        loadAllMeetings()
        loadActiveMeetings()
    }

    fun setSelectedTabIndex(index: Int) {
        viewModelScope.launch {
            _selectedTabIndex.emit(index)
            if (index == 0) {
                loadAllMeetings()
            } else {
                loadActiveMeetings()
            }
        }
    }

    private fun loadAllMeetings() {
        viewModelScope.launch {
            try {
                getAllMeetings.invoke().collect { meetings: List<MeetingEventModel> ->
                    _allMeetingsList.update { meetings }
                    _screenState.value = EventsScreenState.Content(meetings)
                }
            } catch (e: Exception) {
                _screenState.value = EventsScreenState.Error(e.message ?: "Unknown error")
            }
        }
    }

    private fun loadActiveMeetings() {
        viewModelScope.launch {
            try {
                getActiveMeetings.invoke().collect { meeting: List<MeetingEventModel> ->
                    _activeMeetingsList.update { meeting }
                    _screenState.value = EventsScreenState.Content(meeting)
                }
            } catch (e: Exception) {
                _screenState.value = EventsScreenState.Error(e.message ?: "Unknown error")
            }
        }
    }
}