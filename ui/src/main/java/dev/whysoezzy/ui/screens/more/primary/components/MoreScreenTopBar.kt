package dev.whysoezzy.ui.screens.more.primary.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.base.text.TextSubheading1
import dev.whysoezzy.ui.theme.MeetTheme

@Composable
@OptIn(ExperimentalMaterial3Api::class)
internal fun MoreScreenTopBar() {
    TopAppBar(
        title = {
            TextSubheading1(
                text = stringResource(R.string.more),
                color = MeetTheme.colors.neutralActive
            )
        }
    )
}