package ru.wb.meetings.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.wb.meetings.R
import ru.wb.meetings.navigation.NavigationItems
import ru.wb.meetings.ui.base.CustomOutlinedButton
import ru.wb.meetings.ui.base.MainIcon
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MainTypographyTextStyle

@Composable
fun MoreScreen(
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        MainIcon(
            showBadge = false,
            isClickable = false,
            showClip = true,
            modifier = Modifier
                .padding(top = 16.dp)
                .size(64.dp),

        )
        Text(
            modifier =
            Modifier.padding(top = 8.dp),
            text = "Ivan Ivanov",
            style = MainTypographyTextStyle.heading2
        )
        Text(
            text = "+7 999 999-99-99",
            style = MainTypographyTextStyle.bodyText2,
            color = MainColorScheme.neutralWeak,
        )
        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp,)
                .padding(top = 12.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomOutlinedButton(
                isEnabled = true,
                modifier = Modifier,
                onClick = {},
                text = "",
                icon = {
                    Icon(
                        modifier = Modifier.size(8.dp),
                        painter = painterResource(id = R.drawable.icon_twittter),
                        contentDescription = "Delete icon",
                        tint = MainColorScheme.brandDefault
                    )
                }

            )
            CustomOutlinedButton(
                isEnabled = true,
                modifier = Modifier,
                onClick = {},
                text = "",
                icon = {
                    Icon(
                        modifier = Modifier.size(8.dp),
                        painter = painterResource(id = R.drawable.icon_inst),
                        contentDescription = "Delete icon",
                        tint = MainColorScheme.brandDefault
                    )
                }

            )
            CustomOutlinedButton(
                isEnabled = true,
                modifier = Modifier,
                onClick = {},
                text = "",
                icon = {
                    Icon(
                        modifier = Modifier.size(8.dp),
                        painter = painterResource(id = R.drawable.icon_in),
                        contentDescription = "Delete icon",
                        tint = MainColorScheme.brandDefault
                    )
                }

            )
            CustomOutlinedButton(
                isEnabled = true,
                modifier = Modifier,
                onClick = {},
                text = "",
                icon = {
                    Icon(
                        modifier = Modifier.size(8.dp),
                        painter = painterResource(id = R.drawable.icon_fb),
                        contentDescription = "Delete icon",
                        tint = MainColorScheme.brandDefault
                    )
                }

            )

        }
    }
}

@Composable
fun ProfileItem(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                interactionSource = remember {
                    MutableInteractionSource()
                },
                indication = null, onClick = onClick,
            )
    ) {
        MainIcon(
            modifier = Modifier.size(60.dp),
            showBadge = false,
            isClickable = false,
        )
        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .weight(1f)
        ) {
            Text(text = "Ivan", style = MainTypographyTextStyle.bodyText1)
            Text(
                text = "+7 999 999-99-99",
                style = MainTypographyTextStyle.metadata1,
                color = MainColorScheme.neutralWeak,
            )
        }

    }
}
@Composable
fun SettingsItem(
    icon: Painter,
    name: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
            .clickable(
                interactionSource = remember {
                    MutableInteractionSource()
                },
                indication = null, onClick = onClick,
            )
    ) {
        Icon(
            modifier = Modifier.size(16.dp),
            painter = icon,
            tint = MainColorScheme.neutralActive,
            contentDescription = null
        )
        Text(
            modifier = Modifier
                .padding(start = 8.dp)
                .weight(1f),
            text = name,
            style = MainTypographyTextStyle.bodyText1
        )

    }
}

