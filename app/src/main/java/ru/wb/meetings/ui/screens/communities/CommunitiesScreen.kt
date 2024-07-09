package ru.wb.meetings.ui.screens.communities

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.wb.meetings.ui.base.SearchBar
import ru.wb.meetings.ui.widgets.CommunitiesList
import ru.wb.meetings.ui.widgets.CommunityEventModel

@Composable
fun CommunitiesScreen(
    navController: NavController,
    innerPadding: PaddingValues
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
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {

        }
        CommunitiesList(communities = communities, onClick = { id ->
            navController.navigate("detailsCommunity_screen/$id")
        })


    }
}