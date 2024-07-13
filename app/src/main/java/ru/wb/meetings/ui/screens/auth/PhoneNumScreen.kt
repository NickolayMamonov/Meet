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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ru.wb.meetings.R
import ru.wb.meetings.navigation.AuthScreens
import ru.wb.meetings.ui.base.CustomButton
import ru.wb.meetings.ui.theme.MeetTheme
import ru.wb.meetings.ui.widgets.PhoneNumberElement


private const val PHONE_NUM_LENGTH = 10

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneNumScreen(navController: NavController) {
    val phoneNumberState = remember { mutableStateOf("") }
    val countryCodeState = remember { mutableStateOf("+7") }
    val phoneNumberLength = remember { mutableStateOf(false) }
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
                        text = stringResource(R.string.enter_phone_num),
                        style = MeetTheme.typography.heading2,
                        color = MeetTheme.colors.neutralActive,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 32.dp, start = 16.dp, end = 16.dp)

                    )
                }
            }
            item {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 32.dp)
                ) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = stringResource(R.string.we_will_send_confirmation_code),
                        style = MeetTheme.typography.bodyText2,
                        lineHeight = 28.sp,
                        color = MeetTheme.colors.neutralActive,
                        modifier = Modifier
                            .padding(16.dp)
                            .padding(horizontal = 64.dp)
                    )
                }

            }
            item {
                PhoneNumberElement(
                    onPhoneNumberChange = { phoneNumber ->
                    phoneNumberLength.value = phoneNumber.length == PHONE_NUM_LENGTH
                    phoneNumberState.value = phoneNumber
                },
                    onCountryCodeChange = { countryCode ->
                        countryCodeState.value = countryCode
                    }
                )
            }
            item {
                when {
                    phoneNumberLength.value -> {
                        CustomButton(
                            text = stringResource(R.string.Continue),
                            onClick = {
                                navController.navigate(AuthScreens.OtpCodeScreen.route + "/${phoneNumberState.value}/${countryCodeState.value}")
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 64.dp)
                        )
                    }

                    else -> {
                        CustomButton(
                            text = stringResource(R.string.Continue),
                            isEnabled = false,
                            onClick = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 64.dp)
                        )
                    }
                }
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun PreviewAuthPhoneNumScreen() {
    val navController = rememberNavController()
    PhoneNumScreen(navController = navController)
}