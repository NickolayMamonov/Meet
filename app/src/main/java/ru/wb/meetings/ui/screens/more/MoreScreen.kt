package ru.wb.meetings.ui.screens.more

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.wb.meetings.R
import ru.wb.meetings.ui.widgets.ProfileItem
import ru.wb.meetings.ui.widgets.SettingsItem

@Composable
fun MoreScreen(
    navController: NavController,
    innerPadding: PaddingValues
) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileItem(text = "Иван Иванов", subtext ="+7 999 999-99-99" , onClick = { navController.navigate("profile_screen") }, modifier = Modifier.padding(20.dp))
        SettingsItem(icon = painterResource(id = R.drawable.events), name = "Мои встречи" , onClick = { navController.navigate("myEvents_screen") }, modifier = Modifier.padding(20.dp))
    }
}