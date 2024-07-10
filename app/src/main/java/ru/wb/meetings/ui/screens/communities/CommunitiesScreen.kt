package ru.wb.meetings.ui.screens.communities

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.wb.meetings.R
import ru.wb.meetings.navigation.Screen
import ru.wb.meetings.ui.base.SearchBar
import ru.wb.meetings.ui.models.CommunityEventModel
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MainTypographyTextStyle
import ru.wb.meetings.ui.widgets.CommunityEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommunitiesScreen(
    navController: NavController,
) {
    val communities = listOf(
        CommunityEventModel("1", "Спорт", 100),
        CommunityEventModel("2", "Музыка", 200),
        CommunityEventModel("3", "Танцы", 300),
        CommunityEventModel("4", "Искусство", 400),
        CommunityEventModel("5", "Кино", 500),
        CommunityEventModel("6", "Кино", 500),
        CommunityEventModel("7", "Кино", 500),
        CommunityEventModel("8", "Кино", 500),
        CommunityEventModel("9", "Кино", 500),
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.communities),
                        style = MainTypographyTextStyle.subheading1,
                        color = MainColorScheme.neutralActive
                    )
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            item {
                SearchBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {

                }
            }
            items(communities) { community ->

                CommunityEvent(community = community, onClick = {
                    navController.navigate(Screen.CommunitiesRoot.DetailsCommunity.route + "/${community.title}")
                })
            }

        }
    }

}