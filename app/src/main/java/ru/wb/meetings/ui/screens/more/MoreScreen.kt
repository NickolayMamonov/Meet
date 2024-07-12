package ru.wb.meetings.ui.screens.more

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.wb.meetings.R
import ru.wb.meetings.navigation.Screen
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MainTypographyTextStyle
import ru.wb.meetings.ui.widgets.ProfileItem
import ru.wb.meetings.ui.widgets.SettingsItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreScreen(
    navController: NavController,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.more),
                        style = MainTypographyTextStyle.subheading1,
                        color = MainColorScheme.neutralActive
                    )
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                ProfileItem(
                    text = "Иван Иванов",
                    subtext = "+7 999 999-99-99",
                    onClick = {
                        navController.navigate(Screen.MoreRoot.Profile.route)
                    },
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
            item {
                SettingsItem(
                    icon = painterResource(id = R.drawable.events),
                    name = "Мои встречи",
                    onClick = {
                        navController.navigate(Screen.MoreRoot.MyEvents.route)
                    },
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .padding(20.dp)
                )
            }

            item {
                SettingsItem(
                    icon = painterResource(id = R.drawable.ic_theme),
                    name = "Тема",
                    onClick = {},
                    modifier = Modifier.padding(20.dp)
                )
            }
            item {
                SettingsItem(
                    icon = painterResource(id = R.drawable.ic_notification),
                    name = "Уведомления",
                    onClick = {},
                    modifier = Modifier.padding(20.dp)
                )
            }
            item {
                SettingsItem(
                    icon = painterResource(id = R.drawable.ic_security),
                    name = "Безопасность",
                    onClick = {},
                    modifier = Modifier.padding(20.dp)
                )
            }
            item {
                SettingsItem(
                    icon = painterResource(id = R.drawable.ic_memory_and_storage),
                    name = "Память и ресурсы",
                    onClick = {},
                    modifier = Modifier.padding(20.dp)
                )
            }
            item {
                HorizontalDivider(
                    thickness = 1.dp,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                )
            }
            item {
                SettingsItem(
                    icon = painterResource(id = R.drawable.ic_help),
                    name = "Помощь",
                    onClick = {},
                    modifier = Modifier.padding(20.dp)
                )
            }
            item {
                SettingsItem(
                    icon = painterResource(id = R.drawable.ic_invite_friend),
                    name = "Пригласи друга",
                    onClick = {},
                    modifier = Modifier.padding(20.dp)
                )
            }


        }

    }
}