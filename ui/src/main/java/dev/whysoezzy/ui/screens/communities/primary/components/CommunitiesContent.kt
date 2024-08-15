package dev.whysoezzy.ui.screens.communities.primary.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import dev.whysoezzy.common.ScreenState
import dev.whysoezzy.domain.models.CommunityEventModel
import dev.whysoezzy.ui.navigation.Screen
import dev.whysoezzy.ui.screens.ErrorScreen
import dev.whysoezzy.ui.screens.LoadingScreen
import dev.whysoezzy.ui.widgets.CommunityEvent

@Composable
internal fun CommunitiesContent(
    screenState: ScreenState<List<CommunityEventModel>>,
    navController: NavController
) {
    when (screenState) {
        is ScreenState.Content -> {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                item {
                    CommunitiesSearchBar()
                }
                items(screenState.data) { community ->
                    CommunityEvent(
                        community = community,
                        onClick = {
                            navController.navigate(Screen.CommunitiesRoot.DetailsCommunity.route + "/${community.title}")
                        }
                    )
                }
            }
        }

        is ScreenState.Loading -> LoadingScreen()
        is ScreenState.Error -> ErrorScreen()
    }
}