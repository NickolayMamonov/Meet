package ru.wb.meetings.ui.screens.auth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.wb.meetings.R
import ru.wb.meetings.navigation.AuthScreens
import ru.wb.meetings.ui.base.CustomTextButton
import ru.wb.meetings.ui.theme.MeetTheme
import ru.wb.meetings.ui.utils.formatPhoneNumber
import ru.wb.meetings.ui.widgets.OtpElement

private const val TEST_CODE = "1234"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtpCodeScreen(navController: NavController, phoneNumber: String, countryCode: String) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_back),
                            contentDescription = null
                        )
                    }

                },
                title = {}
            )
        }
    ) { innerPadding ->
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 24.dp)


        ) {
            item {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(R.string.enter_code),
                        style = MeetTheme.typography.heading2,
                        color = MeetTheme.colors.neutralActive,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 32.dp, start = 16.dp, end = 16.dp, bottom = 12.dp)

                    )
                }
            }
            item {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(R.string.we_send_code),
                        style = MeetTheme.typography.bodyText2,
                        color = MeetTheme.colors.neutralActive,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }

            }
            item {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 32.dp, top = 16.dp)
                ) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "$countryCode ${formatPhoneNumber(phoneNumber)}",
                        style = MeetTheme.typography.bodyText2,
                        color = MeetTheme.colors.neutralActive,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }
            item {
                OtpElement(onOtpComplete = {
                    when (it) {
                        TEST_CODE -> {
                            navController.navigate(AuthScreens.AddProfileScreen.route)
                        }
                    }
                })
            }
            item {
                CustomTextButton(text = stringResource(R.string.request_code_again), onClick = { /*TODO*/ }, modifier = Modifier.padding(top = 64.dp))
            }
        }
    }

}

