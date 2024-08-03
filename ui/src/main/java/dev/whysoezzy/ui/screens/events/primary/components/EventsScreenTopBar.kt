package dev.whysoezzy.ui.screens.events.primary.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.base.text.TextSubheading1
import dev.whysoezzy.ui.theme.MeetTheme

@Composable
@OptIn(ExperimentalMaterial3Api::class)
internal fun EventsScreenTopBar() {
    TopAppBar(
        title = {
            TextSubheading1(
                text = stringResource(R.string.meetings),
                color = MeetTheme.colors.neutralActive,
                modifier = Modifier.padding(start = 4.dp)
            )
        },
        actions = {
            IconButton(
                onClick = { },
                modifier = Modifier.padding(end = 4.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.add_new),
                    contentDescription = null
                )
            }
        },
    )
}