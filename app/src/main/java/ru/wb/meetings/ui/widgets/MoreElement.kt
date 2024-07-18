package ru.wb.meetings.ui.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import ru.wb.meetings.ui.theme.MainTypographyTextStyle







@Preview(showBackground = true)
@Composable
fun PreviewProfileItemElement() {
    Column {
        ProfileElement(text = "Иван Иванов", subtext = "+7 999 999-99-99", onClick = { /*TODO*/ })
        SettingsElement(
            icon = painterResource(id = R.drawable.events),
            name = "Мои встречи",
            onClick = {},
            modifier = Modifier.padding(20.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        SettingsElement(
            icon = painterResource(id = R.drawable.ic_theme),
            name = "Тема",
            onClick = {},
            modifier = Modifier.padding(20.dp)
        )
        SettingsElement(
            icon = painterResource(id = R.drawable.ic_notification),
            name = "Уведомления",
            onClick = {},
            modifier = Modifier.padding(20.dp)
        )
        SettingsElement(
            icon = painterResource(id = R.drawable.ic_security),
            name = "Безопасность",
            onClick = {},
            modifier = Modifier.padding(20.dp)
        )
        SettingsElement(
            icon = painterResource(id = R.drawable.ic_memory_and_storage),
            name = "Память и ресурсы",
            onClick = {},
            modifier = Modifier.padding(20.dp)
        )
        HorizontalDivider()
        SettingsElement(
            icon = painterResource(id = R.drawable.ic_help),
            name = "Помощь",
            onClick = {},
            modifier = Modifier.padding(20.dp)
        )
        SettingsElement(
            icon = painterResource(id = R.drawable.ic_notification),
            name = "Уведомления",
            onClick = {},
            modifier = Modifier.padding(20.dp)
        )
        SettingsElement(
            icon = painterResource(id = R.drawable.ic_invite_friend),
            name = "Пригласи друга",
            onClick = {},
            modifier = Modifier.padding(20.dp)
        )

    }

}