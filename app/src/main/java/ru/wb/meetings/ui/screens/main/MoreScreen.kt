package ru.wb.meetings.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.whysoezzy.testwbproject.navigation.MoreRouteScreen
import ru.wb.meetings.R
import ru.wb.meetings.ui.base.MainIcon
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MainTypographyTextStyle

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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier.weight(1f, fill = false)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    MainIcon(
                        showBadge = false,
                        isClickable = false,
                        showClip = true,
                        sizeIcon = 24.dp,
                        clipPercent = 50,
                    )
                    Column {
                        Text(text = stringResource(R.string.test_name), style = MainTypographyTextStyle.bodyText1, color = MainColorScheme.neutralActive)
                        Text(text = stringResource(R.string.test_number), style = MainTypographyTextStyle.metadata1, color = MainColorScheme.neutralDisabled)
                    }
                }
            }
            MainIcon(
                showBadge = false,
                isClickable = true,
                sizeIcon = 12.dp,
                image = painterResource(id = R.drawable.arrow_forward),
                onClick = {
                    navController.navigate(MoreRouteScreen.Profile.route)
                }
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.weight(1f, fill = false)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    MainIcon(
                        showBadge = false,
                        isClickable = false,
                        image = painterResource(id = R.drawable.events),
                        sizeIcon = 24.dp,
                    )
                    Text(text = stringResource(id = R.string.my_meetings), style = MainTypographyTextStyle.bodyText1, color = MainColorScheme.neutralActive)

                }
            }
            MainIcon(
                showBadge = false,
                isClickable = true,
                sizeIcon = 12.dp,
                image = painterResource(id = R.drawable.arrow_forward),
                onClick = {
                    navController.navigate(MoreRouteScreen.MyEvents.route)
                }
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.weight(1f, fill = false)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    MainIcon(
                        showBadge = false,
                        isClickable = false,
                        image = painterResource(id = R.drawable.events),
                        sizeIcon = 24.dp,
                    )
                    Text(text = stringResource(R.string.developer_screen), style = MainTypographyTextStyle.bodyText1, color = MainColorScheme.neutralActive)

                }
            }
            MainIcon(
                showBadge = false,
                isClickable = true,
                sizeIcon = 12.dp,
                image = painterResource(id = R.drawable.arrow_forward),
                onClick = {
                    navController.navigate(MoreRouteScreen.Developer.route)
                }
            )
        }



    }
}