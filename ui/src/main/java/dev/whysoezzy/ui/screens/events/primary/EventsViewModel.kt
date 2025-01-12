package dev.whysoezzy.ui.screens.events.primary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.whysoezzy.common.ScreenState
import dev.whysoezzy.domain.models.MeetingEventModel
import dev.whysoezzy.domain.usecases.GetActiveMeetingsUseCase
import dev.whysoezzy.domain.usecases.GetAllMeetingsUseCase
import dev.whysoezzy.ui.utils.FIRST_ELEMENT_TAB_INDEX
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class EventsViewModel(
    private val getAllMeetings: GetAllMeetingsUseCase,
    private val getActiveMeetings: GetActiveMeetingsUseCase
) : ViewModel() {
    private val _screenState =
        MutableStateFlow<ScreenState<List<MeetingEventModel>>>(ScreenState.Loading)
    private val screenState: StateFlow<ScreenState<List<MeetingEventModel>>> = _screenState.asStateFlow()
    private val _selectedTabIndex = MutableStateFlow(FIRST_ELEMENT_TAB_INDEX)
    private val selectedTabIndex: StateFlow<Int> = _selectedTabIndex.asStateFlow()
    private var _allMeetingsList = MutableStateFlow<List<MeetingEventModel>>(emptyList())
    private val allMeetingsList: StateFlow<List<MeetingEventModel>> = _allMeetingsList.asStateFlow()
    private var _activeMeetingsList = MutableStateFlow<List<MeetingEventModel>>(emptyList())
    private val activeMeetingsList: StateFlow<List<MeetingEventModel>> = _activeMeetingsList.asStateFlow()

    fun screenState() = screenState
    fun selectedTabIndex() = selectedTabIndex
    private fun allMeetingsList() = allMeetingsList
    private fun activeMeetingsList() = activeMeetingsList

    val currentList: StateFlow<List<MeetingEventModel>> = combine(
        selectedTabIndex(), allMeetingsList(), activeMeetingsList()
    ) { selectedTabIndex, allMeetingsList, activeMeetingsList ->
        when (selectedTabIndex) {
            FIRST_ELEMENT_TAB_INDEX -> allMeetingsList
            else -> activeMeetingsList
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    init {
        loadAllMeetings()
        loadActiveMeetings()
    }

    internal fun setSelectedTabIndex(index: Int) {
        viewModelScope.launch {
            _selectedTabIndex.emit(index)
            if (index == FIRST_ELEMENT_TAB_INDEX) {
                loadAllMeetings()
            } else {
                loadActiveMeetings()
            }
        }
    }

    private fun loadAllMeetings() {
        viewModelScope.launch {
            try {
                getAllMeetings.invoke().collect { meetings ->
                    _allMeetingsList.update { meetings }
                    _screenState.value = ScreenState.Content(meetings)
                }
            } catch (e: Exception) {
                _screenState.value = ScreenState.Error(e.message ?: "All Meetings not found!")
            }
        }
    }

    private fun loadActiveMeetings() {
        viewModelScope.launch {
            try {
                getActiveMeetings.invoke().collect { meeting ->
                    _activeMeetingsList.update { meeting }
                    _screenState.value = ScreenState.Content(meeting)
                }
            } catch (e: Exception) {
                _screenState.value = ScreenState.Error(e.message ?: "Active Meetings not found!")
            }
        }
    }
}