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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ru.wb.meetings.R
import ru.wb.meetings.navigation.AuthScreens
import ru.wb.meetings.ui.base.CustomButton
import ru.wb.meetings.ui.base.UserAvatar
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MainTypographyTextStyle
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
                        navController.navigateUp()
                        navController.navigateUp()
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_back),
                            contentDescription = null
                        )
                    }

                },
                title = {
                    Text(
                        text = stringResource(id = R.string.profile),
                        style = MainTypographyTextStyle.subheading1,
                        color = MainColorScheme.neutralActive
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
                        .background(MainColorScheme.neutralSecondaryBackground)

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
                                    Text(
                                        stringResource(R.string.name_required),
                                        style = MeetTheme.typography.bodyText1,
                                        color = MeetTheme.colors.neutralWeak
                                    )
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
                                    Text(
                                        stringResource(R.string.surname_optionally),
                                        style = MeetTheme.typography.bodyText1,
                                        color = MeetTheme.colors.neutralWeak
                                    )
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
                if (firstName.isNotEmpty()) {
                    CustomButton(
                        text = stringResource(R.string.save),
                        onClick = {
                            navController.navigate(AuthScreens.MainScreen.route) {
                                popUpTo(route = AuthScreens.PhoneNumScreen.route){
                                    inclusive = true
                                }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 64.dp)
                    )
                } else {
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

@Preview(showBackground = true)
@Composable
fun PreviewAddProfileScreen() {
    MeetTheme {
        AddProfileScreen(navController = rememberNavController())
    }
}