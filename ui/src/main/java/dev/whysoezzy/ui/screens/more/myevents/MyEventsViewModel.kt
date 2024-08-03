package dev.whysoezzy.ui.screens.more.myevents

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.whysoezzy.common.ScreenState
import dev.whysoezzy.domain.models.MeetingEventModel
import dev.whysoezzy.domain.usecases.GetPassedMeetingsUseCase
import dev.whysoezzy.domain.usecases.GetPlannedMeetingsUseCase
import dev.whysoezzy.ui.utils.FIRST_ELEMENT_TAB_INDEX
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class MyEventsViewModel(
    private val getPassedMeetingsUseCase: GetPassedMeetingsUseCase,
    private val getPlannedMeetingsUseCase: GetPlannedMeetingsUseCase
) : ViewModel() {
    private val _screenState = MutableStateFlow<ScreenState<List<MeetingEventModel>>>(ScreenState.Loading)
    private val screenState: StateFlow<ScreenState<List<MeetingEventModel>>> = _screenState.asStateFlow()
    private val _selectedTabIndex = MutableStateFlow(FIRST_ELEMENT_TAB_INDEX)
    private val selectedTabIndex: StateFlow<Int> = _selectedTabIndex.asStateFlow()
    private var _passedMeetingsList = MutableStateFlow<List<MeetingEventModel>>(emptyList())
    private val passedMeetingsList: StateFlow<List<MeetingEventModel>> =
        _passedMeetingsList.asStateFlow()
    private var _plannedMeetingsList = MutableStateFlow<List<MeetingEventModel>>(emptyList())
    private val plannedMeetingsList: StateFlow<List<MeetingEventModel>> =
        _plannedMeetingsList.asStateFlow()

    fun screenState() = screenState
    fun selectedTabIndex() = selectedTabIndex
    private fun passedMeetingsList() = passedMeetingsList
    private fun plannedMeetingsList() = plannedMeetingsList

    val currentList: StateFlow<List<MeetingEventModel>> = combine(
        selectedTabIndex(), plannedMeetingsList(), passedMeetingsList()
    ) { selectedTabIndex, plannedMeetingList, passedMeetingsList ->
        when (selectedTabIndex) {
            FIRST_ELEMENT_TAB_INDEX -> plannedMeetingList
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
                FIRST_ELEMENT_TAB_INDEX -> {
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