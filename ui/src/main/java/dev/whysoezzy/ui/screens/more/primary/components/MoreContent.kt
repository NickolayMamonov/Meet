package dev.whysoezzy.ui.screens.more.primary.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.whysoezzy.common.ScreenState
import dev.whysoezzy.domain.models.UserProfileModel

@Composable
internal fun MoreContent(
    screenState: ScreenState.Content<UserProfileModel>,
    navController: NavController
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            MoreScreenProfile(screenState.data, navController)
        }
        item {
            MoreScreenMyEvents(navController)
        }
        item {
            MoreScreenTheme()
        }
        item {
            MoreScreenNotifications()
        }
        item {
            MoreScreenSecurity()
        }
        item {
            MoreScreenMemoryStorage()
        }
        item {
            HorizontalDivider(
                thickness = 1.dp,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
            )
        }
        item {
            MoreScreenHelp()
        }
        item {
            MoreScreenInviteFriend()
        }
    }
}