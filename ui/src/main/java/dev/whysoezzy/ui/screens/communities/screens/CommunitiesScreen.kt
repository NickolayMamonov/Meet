package dev.whysoezzy.ui.screens.communities.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.whysoezzy.common.ScreenState
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.base.SearchBar
import dev.whysoezzy.ui.base.text.TextSubheading1
import dev.whysoezzy.ui.navigation.Screen
import org.koin.androidx.compose.koinViewModel
import dev.whysoezzy.ui.screens.communities.viewmodels.CommunitiesViewModel
import dev.whysoezzy.ui.theme.MeetTheme
import dev.whysoezzy.ui.widgets.CommunityEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommunitiesScreen(
    navController: NavController,
    viewModel: CommunitiesViewModel = koinViewModel()
) {
    val screenState by viewModel.screenState().collectAsState()
    val currentState = screenState

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    TextSubheading1(
                        text = stringResource(R.string.communities),
                        color = MeetTheme.colors.neutralActive
                    )
                }
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when(currentState) {
                is ScreenState.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                is ScreenState.Error -> {
                    Text(text = "Error: ", modifier = Modifier.align(Alignment.Center))
                }
                is ScreenState.Content -> {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        item {
                            SearchBar(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 20.dp, vertical = 8.dp)
                            ) {

                            }
                        }
                        items(currentState.data) { community ->
                            CommunityEvent(
                                community = community,
                                onClick = {
                                    navController.navigate(Screen.CommunitiesRoot.DetailsCommunity.route + "/${community.title}")
                                })
                        }
                    }
                }
            }
        }
    }
}