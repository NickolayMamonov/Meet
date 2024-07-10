package ru.wb.meetings.ui.screens.communities

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.wb.meetings.R
import ru.wb.meetings.navigation.Screen
import ru.wb.meetings.ui.models.MeetingEventModel
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MainTypographyTextStyle
import ru.wb.meetings.ui.widgets.MeetingEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsCommunityScreen(navController: NavController, name: String) {
    val description = LoremIpsum().values.first()
    val myMeetingsList = listOf(
        MeetingEventModel("1", "Developer Meeting", "13.09.2024 — Москва", false),
        MeetingEventModel("2", "Developer Meeting", "13.09.2024 — Москва", false),
        MeetingEventModel("3", "Developer Meeting", "13.09.2024 — Москва", true),
        MeetingEventModel("4", "Developer Meeting", "13.09.2024 — Москва", false),
        MeetingEventModel("5", "Developer Meeting", "13.09.2024 — Москва", true),
    )
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = name,
                        style = MainTypographyTextStyle.subheading1,
                        color = MainColorScheme.neutralActive
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
                .padding(18.dp)
        ) {
            item {
                Text(
                    text = description,
                    maxLines = 13,
                    overflow = TextOverflow.Ellipsis,
                    style = MainTypographyTextStyle.metadata1,
                    color = MainColorScheme.neutralWeak,
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = stringResource(R.string.community_events),
                    style = MainTypographyTextStyle.bodyText1,
                    color = MainColorScheme.neutralWeak
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            items(myMeetingsList) { meeting ->
                MeetingEvent(meeting, onClick = {
                    navController.navigate(Screen.CommunitiesRoot.DetailsCommunity.DetailsEvent.route + "/${meeting.title}")
                })
            }


        }


    }


}
