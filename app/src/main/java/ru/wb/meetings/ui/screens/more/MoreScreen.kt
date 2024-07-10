package ru.wb.meetings.ui.screens.more

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
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
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfileItem(
                text = "Иван Иванов",
                subtext = "+7 999 999-99-99",
                onClick = {
                    navController.navigate(Screen.MoreRoot.Profile.route)
                },
                modifier = Modifier.padding(20.dp)
            )
            SettingsItem(
                icon = painterResource(id = R.drawable.events),
                name = "Мои встречи",
                onClick = {
                    navController.navigate(Screen.MoreRoot.MyEvents.route)
                },
                modifier = Modifier.padding(20.dp)
            )
        }

    }
}