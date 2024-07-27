package dev.whysoezzy.ui.screens.more.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import dev.whysoezzy.common.ScreenState
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.navigation.Screen
import dev.whysoezzy.ui.base.text.TextBody1
import dev.whysoezzy.ui.base.text.TextSubheading1
import dev.whysoezzy.ui.screens.more.viewmodels.MyEventsViewModel
import dev.whysoezzy.ui.theme.MeetTheme
import dev.whysoezzy.ui.utils.MyEventsTabs
import dev.whysoezzy.ui.widgets.MeetingEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyEventsScreen(
    navController: NavController,
    viewModel: MyEventsViewModel = koinViewModel()
) {
    val screenState by viewModel.screenState().collectAsState()
    val currentState = screenState
    val selectedTabIndex by viewModel.selectedTabIndex().collectAsState()
    val currentList by viewModel.currentList.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    TextSubheading1(
                        text = stringResource(id = R.string.my_meetings),
                        color = MeetTheme.colors.neutralActive
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_back),
                            contentDescription = null
                        )
                    }

                }
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)){
            when(currentState){
                is ScreenState.Content -> {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 20.dp)
                    ) {
                        item {
                            TabRow(
                                selectedTabIndex = selectedTabIndex,
                                contentColor = MeetTheme.colors.brandDefault,
                                indicator = { tabPositions ->
                                    SecondaryIndicator(
                                        modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                                        color = MeetTheme.colors.brandDefault
                                    )
                                },
                                modifier = Modifier.padding(bottom = 8.dp)
                            ) {
                                MyEventsTabs.entries.forEachIndexed { index, tab ->
                                    Tab(
                                        text = {
                                            TextBody1(
                                                text = stringResource(id = tab.title),
                                                color = when (selectedTabIndex) {
                                                    index -> MeetTheme.colors.brandDefault
                                                    else -> MeetTheme.colors.neutralWeak
                                                }
                                            )
                                        },
                                        selected = selectedTabIndex == index,
                                        onClick = { viewModel.setSelectedTabIndex(index)}
                                    )
                                }
                            }
                        }
                        items(currentList) { meeting ->
                            MeetingEvent(meeting = meeting, onClick = {
                                navController.navigate(Screen.MoreRoot.MyEvents.DetailsEvent.route + "/${meeting.title}")
                            })
                        }
                    }

                }
                is ScreenState.Error -> {
                    Text(text = "Error: ", modifier = Modifier.align(Alignment.Center))
                }
                ScreenState.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }
        }
    }
}






