package ru.wb.meetings.ui.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.wb.meetings.R
import ru.wb.meetings.ui.base.MainIcon
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MainTypographyTextStyle



@Composable
fun ProfileItem(
    text: String,
    subtext: String,
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
                indication = null, onClick = onClick
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        MainIcon(
            showBadge = false,
            isClickable = false,
            showClip = true,
            sizeIcon = 24.dp,
            clipPercent = 50,
        )
        Column(
            modifier = Modifier
                .padding(start = 10.dp)
                .weight(1f)

        ) {
            Text(
                text = text,
                style = MainTypographyTextStyle.bodyText1,
                color = MainColorScheme.neutralActive
            )
            Text(
                text = subtext,
                style = MainTypographyTextStyle.metadata1,
                color = MainColorScheme.neutralDisabled
            )
        }
        MainIcon(
            showBadge = false,
            isClickable = false,
            image = painterResource(id = R.drawable.arrow_forward),
            sizeIcon = 12.dp,
        )
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
        MainIcon(showBadge = false, isClickable = false, image = icon, sizeIcon = 24.dp)
        Text(
            modifier = Modifier
                .padding(start = 6.dp)
                .weight(1f)
                .align(Alignment.CenterVertically),
            text = name,
            style = MainTypographyTextStyle.bodyText1
        )
        MainIcon(
            showBadge = false,
            isClickable = false,
            image = painterResource(id = R.drawable.arrow_forward),
            sizeIcon = 12.dp,
        )
    }
}
