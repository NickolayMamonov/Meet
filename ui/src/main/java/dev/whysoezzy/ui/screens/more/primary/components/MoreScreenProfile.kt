package dev.whysoezzy.ui.screens.more.primary.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.whysoezzy.domain.models.UserProfileModel
import dev.whysoezzy.ui.navigation.Screen
import dev.whysoezzy.ui.widgets.ProfileElement

@Composable
internal fun MoreScreenProfile(
    profile: UserProfileModel,
    navController: NavController
) {
    ProfileElement(
        text = profile.name,
        subtext = profile.phoneNumber,
        onClick = {
            navController.navigate(Screen.MoreRoot.Profile.route)
        },
        modifier = Modifier.padding(top = 8.dp)
    )
}