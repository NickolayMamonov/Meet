package ru.wb.meetings.ui.screens.more

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ru.wb.meetings.R
import ru.wb.meetings.ui.base.MainIcon
import ru.wb.meetings.ui.base.UserAvatar
import ru.wb.meetings.ui.base.buttons.CustomOutlinedButton
import ru.wb.meetings.ui.base.text.TextBody2
import ru.wb.meetings.ui.base.text.TextHeading2
import ru.wb.meetings.ui.base.text.TextSubheading1
import ru.wb.meetings.ui.theme.MeetTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavController,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    TextSubheading1(
                        text = stringResource(id = R.string.profile),
                        color = MeetTheme.colors.neutralActive
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_back),
                            contentDescription = null
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {

                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.edit),
                            contentDescription = null
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MeetTheme.colors.neutralWhite
                )
            )

        }
    ) { innerPadding ->
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(MeetTheme.colors.neutralWhite)
                .padding(top = 50.dp),

            ) {
            item {
                UserAvatar(
                    size = 200.dp,
                )
            }
            item {
                TextHeading2(
                    text = stringResource(id = R.string.test_name),
                    color = MeetTheme.colors.neutralActive,
                    modifier = Modifier.padding(top = 16.dp, bottom = 4.dp)
                )
            }
            item {
                TextBody2(
                    text = stringResource(id = R.string.test_number),
                    color = MeetTheme.colors.neutralDisabled,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }
            item {
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

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileItemElement() {
    val navController = rememberNavController()
    ProfileScreen(navController = navController)
}