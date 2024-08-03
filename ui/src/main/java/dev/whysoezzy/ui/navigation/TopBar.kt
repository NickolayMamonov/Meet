package dev.whysoezzy.ui.navigation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dev.whysoezzy.ui.base.text.TextSubheading1
import dev.whysoezzy.ui.theme.MeetTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TopBar(
    navigationIcon: Int? = null,
    title: String? = null,
    actions: @Composable () -> Unit = {},
    onNavigationIconClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    TopAppBar(
        navigationIcon = {
            if (navigationIcon != null) {
                IconButton(
                    onClick = onNavigationIconClick,
                    modifier = Modifier.padding(start = 4.dp)
                ) {
                    Icon(
                        painter = painterResource(id = navigationIcon),
                        contentDescription = null
                    )
                }
            }
        },
        title = {
            if (title != null) {
                TextSubheading1(
                    text = title,
                    color = MeetTheme.colors.neutralActive,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        },
    )
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {

        if (title != null) {
            TextSubheading1(
                text = title,
                color = MeetTheme.colors.neutralActive,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
        actions()
    }
}