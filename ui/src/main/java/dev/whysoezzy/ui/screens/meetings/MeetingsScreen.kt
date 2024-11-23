package dev.whysoezzy.ui.screens.meetings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.whysoezzy.common.ScreenState
import dev.whysoezzy.ui.base.SearchBar
import dev.whysoezzy.ui.base.SearchField
import org.koin.androidx.compose.koinViewModel

@Composable
fun MeetingsScreen(
    viewModel: MeetingsViewModel = koinViewModel(),
    onMeetingClick: (String) -> Unit,
    onCommunityClick: (String) -> Unit
) {
    val uiState by viewModel.uiState.
    Column(modifier = Modifier.fillMaxSize()) {
//        SearchField(
//            searchField ="" ,
//            onFieldChange ={} ,
//            onClearField = {}
//        )
//        when(val state = uiState){
//            is ScreenState.Loading ->{}
//            is ScreenState.Error -> {
//
//            }
//            is ScreenState.Content<> ->{
//
//            }
//        }
    }
}