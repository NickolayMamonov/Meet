package dev.whysoezzy.ui.screens.meetings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.whysoezzy.domain.usecases.GetCommunitiesUseCase
import dev.whysoezzy.domain.usecases.GetFeaturedMeetingsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MeetingsViewModel(
    private val getMeetingsUseCase: GetFeaturedMeetingsUseCase,
    private val getCommunitiesUseCase: GetCommunitiesUseCase,
    private val getContentBlocksUseCase: GetContentBlocksUseCase
) : ViewModel() {
    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    private val _uiState = MutableStateFlow<MainFeedUiState>(MainFeedUiState.Loading)
    val uiState = _uiState.asStateFlow()

    private val _selectedTags = MutableStateFlow<List<String>>(emptyList())
    val selectedTags = _selectedTags.asStateFlow()

    init {
        loadContent()
    }

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
        loadContent()
    }

    fun onTagSelected(tag: String) {
        _selectedTags.value = _selectedTags.value + tag
        loadContent()
    }

    fun onTagUnselected(tag: String) {
        _selectedTags.value = _selectedTags.value - tag
        loadContent()
    }

    private fun loadContent() {
        viewModelScope.launch {
            _uiState.value = MainFeedUiState.Loading

            try {
                // Параллельно загружаем все данные
                coroutineScope {
                    val featuredMeetings = async { getMeetingsUseCase.getFeaturedMeetings() }
                    val upcomingMeetings = async { getMeetingsUseCase.getUpcomingMeetings() }
                    val communities = async { getCommunitiesUseCase.getSuggestedCommunities() }
                    val contentBlocks = async { getContentBlocksUseCase.getContentBlocks() }

                    _uiState.value = MainFeedUiState.Success(
                        featuredMeetings = featuredMeetings.await(),
                        upcomingMeetings = upcomingMeetings.await(),
                        communities = communities.await(),
                        contentBlocks = contentBlocks.await()
                    )
                }
            } catch (e: Exception) {
                _uiState.value = MainFeedUiState.Error(e.message ?: "Unknown error")
            }
        }
    }
}