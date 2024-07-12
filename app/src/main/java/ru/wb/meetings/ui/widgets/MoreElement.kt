package ru.wb.meetings.ui.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.wb.meetings.R
import ru.wb.meetings.ui.base.MainIcon
import ru.wb.meetings.ui.base.UserAvatar
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
            .padding(vertical = 8.dp, horizontal = 20.dp)
            .clickable(
                interactionSource = remember {
                    MutableInteractionSource()
                },
                indication = null, onClick = onClick
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        UserAvatar(size = 40.dp)
        Spacer(modifier = Modifier.width(4.dp))
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
            Spacer(modifier = Modifier.height(6.dp))
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
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
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


@Preview(showBackground = true)
@Composable
fun PreviewProfileItemElement() {
    Column {
        ProfileItem(text = "Иван Иванов", subtext = "+7 999 999-99-99", onClick = { /*TODO*/ })
        SettingsItem(
            icon = painterResource(id = R.drawable.events),
            name = "Мои встречи",
            onClick = {},
            modifier = Modifier.padding(20.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        SettingsItem(
            icon = painterResource(id = R.drawable.ic_theme),
            name = "Тема",
            onClick = {},
            modifier = Modifier.padding(20.dp)
        )
        SettingsItem(
            icon = painterResource(id = R.drawable.ic_notification),
            name = "Уведомления",
            onClick = {},
            modifier = Modifier.padding(20.dp)
        )
        SettingsItem(
            icon = painterResource(id = R.drawable.ic_security),
            name = "Безопасность",
            onClick = {},
            modifier = Modifier.padding(20.dp)
        )
        SettingsItem(
            icon = painterResource(id = R.drawable.ic_memory_and_storage),
            name = "Память и ресурсы",
            onClick = {},
            modifier = Modifier.padding(20.dp)
        )
        HorizontalDivider()
        SettingsItem(
            icon = painterResource(id = R.drawable.ic_help),
            name = "Помощь",
            onClick = {},
            modifier = Modifier.padding(20.dp)
        )
        SettingsItem(
            icon = painterResource(id = R.drawable.ic_notification),
            name = "Уведомления",
            onClick = {},
            modifier = Modifier.padding(20.dp)
        )
        SettingsItem(
            icon = painterResource(id = R.drawable.ic_invite_friend),
            name = "Пригласи друга",
            onClick = {},
            modifier = Modifier.padding(20.dp)
        )

    }

}