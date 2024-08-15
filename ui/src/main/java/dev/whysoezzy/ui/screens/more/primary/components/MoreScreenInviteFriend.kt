package dev.whysoezzy.ui.screens.more.primary.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.widgets.SettingsElement

@Composable
internal fun MoreScreenInviteFriend() {
    SettingsElement(
        icon = painterResource(id = R.drawable.ic_invite_friend),
        name = stringResource(R.string.invite_friend),
        onClick = {},
    )
}