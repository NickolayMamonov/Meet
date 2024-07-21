package ru.wb.meetings.ui.screens.more.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.wb.meetings.R
import ru.wb.meetings.ui.navigation.Screen
import ru.wb.meetings.ui.base.text.TextBody1
import ru.wb.meetings.ui.base.text.TextSubheading1
import ru.wb.meetings.ui.screens.more.viewmodels.MyEventsViewModel
import ru.wb.meetings.ui.theme.MeetTheme
import ru.wb.meetings.ui.utils.MyEventsTabs
import ru.wb.meetings.ui.widgets.MeetingEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyEventsScreen(
    navController: NavController,
    viewModel: MyEventsViewModel = koinViewModel()
) {
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
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
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
}






