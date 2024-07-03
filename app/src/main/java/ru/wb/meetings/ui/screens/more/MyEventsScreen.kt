package ru.wb.meetings.ui.screens.more

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.whysoezzy.testwbproject.navigation.BottomNavigationBar
import dev.whysoezzy.testwbproject.navigation.Graph
import ru.wb.meetings.R
import ru.wb.meetings.ui.base.MainIcon
import ru.wb.meetings.ui.screens.main.MeetingEventModel
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MainTypographyTextStyle
import ru.wb.meetings.ui.utils.bottomNavigationItemsList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyEventsScreen(
    navController: NavController,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Мои Встречи", style = MainTypographyTextStyle.subheading1, color = MainColorScheme.neutralActive) },
                navigationIcon = {
                    MainIcon(
                        showBadge = false,
                        isClickable = true,
                        sizeIcon = 12.dp,
                        image = painterResource(id = R.drawable.arrow_back),
                        onClick = {
                            navController.navigateUp()
                        }
                    )
                }
            )
        },
        bottomBar = {
            BottomNavigationBar(
                items = bottomNavigationItemsList,
                currentRoute = Graph.MoreGraph,
                onClick = { navController.navigateUp()
                }
            )
        }
    ) { innerPadding ->
        var selectedTabIndex by remember { mutableStateOf(0) }
        val allMeetingsList = listOf(
            MeetingEventModel("Встреча 1", "Описание 1", false),
            MeetingEventModel("Встреча 2", "Описание 2", true),
            MeetingEventModel("Встреча 2", "Описание 2", true),
            MeetingEventModel("Встреча 2", "Описание 2", false),
            MeetingEventModel("Встреча 2", "Описание 2", true),
        )
        val activeMeetingsList = allMeetingsList.filter { !it.isEnded }
        val inactiveMeetingsList = allMeetingsList.filter { it.isEnded }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                TabRow(selectedTabIndex = selectedTabIndex) {
                    Tabs.entries.forEachIndexed { index, tab ->
                        Tab(
                            text = { Text(tab.title) },
                            selected = selectedTabIndex == index,
                            onClick = { selectedTabIndex = index }
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                when (selectedTabIndex) {
                    0 -> ru.wb.meetings.ui.screens.main.MeetingsList(activeMeetingsList)
                    1 -> ru.wb.meetings.ui.screens.main.MeetingsList(inactiveMeetingsList)
                }


            }
        }
    }
}


enum class Tabs(val title: String) {
    PLANNED("Запланировано"),
    PASSED("Уже прошли")
}



