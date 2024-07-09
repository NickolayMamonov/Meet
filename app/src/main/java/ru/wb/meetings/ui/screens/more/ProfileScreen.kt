package ru.wb.meetings.ui.screens.more

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import ru.wb.meetings.R
import ru.wb.meetings.ui.base.CustomOutlinedButton
import ru.wb.meetings.ui.base.MainIcon
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MainTypographyTextStyle

@Composable
fun ProfileScreen(
    navController: NavController,
    innerPadding: PaddingValues
) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MainIcon(
            showBadge = false,
            isClickable = true,
            sizeIcon = 128.dp,
        )
        Text(
            text = stringResource(id = R.string.test_name),
            style = MainTypographyTextStyle.heading2,
            color = MainColorScheme.neutralActive
        )
        Text(
            text = stringResource(id = R.string.test_number),
            style = MainTypographyTextStyle.bodyText2,
            color = MainColorScheme.neutralDisabled
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            CustomOutlinedButton(
                icon = {
                    MainIcon(
                        showBadge = false,
                        isClickable = false,
                        sizeIcon = 24.dp,
                        image = painterResource(id = R.drawable.icon_twittter)
                    )
                },
                onClick = {

                },
            )
            CustomOutlinedButton(
                icon = {
                    MainIcon(
                        showBadge = false,
                        isClickable = false,
                        sizeIcon = 24.dp,
                        image = painterResource(id = R.drawable.icon_inst)
                    )
                },
                onClick = {

                },
            )
            CustomOutlinedButton(
                icon = {
                    MainIcon(
                        showBadge = false,
                        isClickable = false,
                        sizeIcon = 24.dp,
                        image = painterResource(id = R.drawable.icon_in)
                    )
                },
                onClick = {

                },
            )
            CustomOutlinedButton(
                icon = {
                    MainIcon(
                        showBadge = false,
                        isClickable = false,
                        sizeIcon = 24.dp,
                        image = painterResource(id = R.drawable.icon_fb)
                    )
                },
                onClick = {

                },
            )
        }
    }
}