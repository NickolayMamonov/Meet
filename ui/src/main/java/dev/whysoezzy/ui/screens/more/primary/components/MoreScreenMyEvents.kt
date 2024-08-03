package dev.whysoezzy.ui.screens.more.primary.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.navigation.Screen
import dev.whysoezzy.ui.widgets.SettingsElement

@Composable
internal fun MoreScreenMyEvents(navController: NavController) {
    SettingsElement(
        icon = painterResource(id = R.drawable.events),
        name = stringResource(id = R.string.my_meetings),
        onClick = {
            navController.navigate(Screen.MoreRoot.MyEvents.route)
        },
        modifier = Modifier.padding(bottom = 20.dp)
    )
}