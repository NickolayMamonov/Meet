package dev.whysoezzy.ui.screens.more.primary.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.widgets.SettingsElement

@Composable
internal fun MoreScreenMemoryStorage() {
    SettingsElement(
        icon = painterResource(id = R.drawable.ic_memory_and_storage),
        name = stringResource(R.string.memory_and_resources),
        onClick = {},
    )
}