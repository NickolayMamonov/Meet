package ru.wb.meetings.ui.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.wb.meetings.R
import ru.wb.meetings.navigation.AuthScreens
import ru.wb.meetings.ui.base.UserAvatar
import ru.wb.meetings.ui.base.buttons.CustomButton
import ru.wb.meetings.ui.base.text.TextBody1
import ru.wb.meetings.ui.base.text.TextSubheading1
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MeetTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProfileScreen(navController: NavController) {
    val (firstName, setFirstName) = remember { mutableStateOf("") }
    val (lastName, setLastName) = remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(AuthScreens.MainScreen.route) {
                            popUpTo(AuthScreens.PhoneNumScreen.route) {
                                inclusive = false
                            }
                        }
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_back),
                            contentDescription = null
                        )
                    }

                },
                title = {
                    TextSubheading1(
                        text = stringResource(id = R.string.profile),
                        color = MeetTheme.colors.neutralActive
                    )
                },
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
                UserAvatar(
                    size = 120.dp,
                    image = null,
                    onClick = {},
                    isBadge = true
                )
            }
            item {
                Box(
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(MeetTheme.colors.neutralSecondaryBackground)

                ) {
                    BasicTextField(
                        value = firstName,
                        onValueChange = setFirstName,
                        singleLine = true,
                        textStyle = MeetTheme.typography.bodyText1,
                        cursorBrush = SolidColor(Color.Transparent),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        decorationBox = { innerTextField ->
                            Box(
                                contentAlignment = Alignment.CenterStart,
                                modifier = Modifier
                                    .padding(start = 8.dp)
                                    .fillMaxWidth()
                            ) {
                                if (firstName.isEmpty()) {
                                    TextBody1(text = stringResource(R.string.name_required), color = MeetTheme.colors.neutralWeak)
                                }
                                innerTextField()
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp)
                    )
                }

            }
            item {
                Box(
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(MainColorScheme.neutralSecondaryBackground)

                ) {
                    BasicTextField(
                        value = lastName,
                        onValueChange = setLastName,
                        singleLine = true,
                        textStyle = MeetTheme.typography.bodyText1,
                        cursorBrush = SolidColor(Color.Transparent),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        decorationBox = { innerTextField ->
                            Box(
                                contentAlignment = Alignment.CenterStart,
                                modifier = Modifier
                                    .padding(start = 8.dp)
                                    .fillMaxWidth()
                            ) {
                                if (lastName.isEmpty()) {
                                    TextBody1(text = stringResource(R.string.surname_optionally), color = MeetTheme.colors.neutralWeak)
                                }
                                innerTextField()
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp)
                    )
                }
            }
            item {
                when {
                    firstName.isNotEmpty() -> {
                        CustomButton(
                            text = stringResource(R.string.save),
                            onClick = {
                                navController.navigate(AuthScreens.MainScreen.route) {
                                    popUpTo(route = AuthScreens.PhoneNumScreen.route) {
                                        inclusive = true
                                    }
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 64.dp)
                        )
                    }
                    else -> {
                        CustomButton(
                            text = stringResource(R.string.save),
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
