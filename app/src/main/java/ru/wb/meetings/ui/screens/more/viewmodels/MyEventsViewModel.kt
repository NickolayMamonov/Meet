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
import dev.whysoezzy.domain.models.MeetingEventModel
import dev.whysoezzy.domain.usecases.GetPassedMeetingsUseCase
import dev.whysoezzy.domain.usecases.GetPlannedMeetingsUseCase
import ru.wb.meetings.ui.screens.more.states.MyEventsScreenState

class MyEventsViewModel(
    private val getPassedMeetingsUseCase: GetPassedMeetingsUseCase,
    private val getPlannedMeetingsUseCase: GetPlannedMeetingsUseCase
) : ViewModel() {
    private val _screenState = MutableStateFlow<MyEventsScreenState>(MyEventsScreenState.Loading)
    private val screenState: StateFlow<MyEventsScreenState> = _screenState.asStateFlow()

    fun screenState() = screenState

    private val _selectedTabIndex = MutableStateFlow(0)
    private val selectedTabIndex: StateFlow<Int> = _selectedTabIndex.asStateFlow()

    fun selectedTabIndex() = selectedTabIndex

    private var _passedMeetingsList = MutableStateFlow<List<MeetingEventModel>>(emptyList())
    private val passedMeetingsList: StateFlow<List<MeetingEventModel>> = _passedMeetingsList.asStateFlow()

    fun passedMeetingsList() = passedMeetingsList

    private var _plannedMeetingsList = MutableStateFlow<List<MeetingEventModel>>(emptyList())
    private val plannedMeetingsList: StateFlow<List<MeetingEventModel>> = _plannedMeetingsList.asStateFlow()

    fun plannedMeetingsList() = plannedMeetingsList

    private val _events = MutableStateFlow<List<MeetingEventModel>>(emptyList())
    private val events: StateFlow<List<MeetingEventModel>> = _events.asStateFlow()

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
                getPassedMeetingsUseCase.invoke().collect { meetings:List<MeetingEventModel> ->
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
                getPlannedMeetingsUseCase.invoke().collect { meetings :List<MeetingEventModel>->
                    _plannedMeetingsList.update { meetings }
                    _screenState.value = MyEventsScreenState.Content(meetings)
                }
            } catch (e: Exception) {
                _screenState.value = MyEventsScreenState.Error(e.message ?: "Error")
            }
        }
    }
}