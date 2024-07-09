package ru.wb.meetings.ui.screens.more

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.wb.meetings.R
import ru.wb.meetings.ui.base.ChipGroup
import ru.wb.meetings.ui.base.CustomButton
import ru.wb.meetings.ui.base.CustomOutlinedButton
import ru.wb.meetings.ui.base.CustomTextButton
import ru.wb.meetings.ui.base.MainIcon
import ru.wb.meetings.ui.base.SearchBar
import ru.wb.meetings.ui.rows.TypographyRow
import ru.wb.meetings.ui.theme.MainTypographyTextStyle

@Composable
fun DeveloperScreen(
    navController: NavController,
) {
    Column {
        LazyColumn {
            item {
                Spacer(modifier = Modifier.height(32.dp))
                Row {
                    CustomButton(
                        text = "Button",
                        onClick = {},
                        isEnabled = true,
                        modifier = Modifier
                            .padding(8.dp)
                            .weight(1f)
                            .fillMaxWidth()
                    )
                    CustomOutlinedButton(
                        text = "Button",
                        onClick = {},
                        isEnabled = true,
                        modifier = Modifier
                            .padding(8.dp)
                            .weight(1f)
                            .fillMaxWidth()
                    )
                    CustomTextButton(
                        text = "Button",
                        onClick = {},
                        isEnabled = true,
                        modifier = Modifier
                            .padding(8.dp)
                            .weight(1f)
                            .fillMaxWidth()
                    )
                }
                Row {
                    CustomButton(
                        text = "Button",
                        onClick = {},
                        isEnabled = false,
                        modifier = Modifier
                            .padding(8.dp)
                            .weight(1f)
                            .fillMaxWidth()
                    )
                    CustomOutlinedButton(
                        text = "Button",
                        onClick = {},
                        isEnabled = false,
                        modifier = Modifier
                            .padding(8.dp)
                            .weight(1f)
                            .fillMaxWidth()
                    )
                    CustomTextButton(
                        text = "Button",
                        onClick = {},
                        isEnabled = false,
                        modifier = Modifier
                            .padding(8.dp)
                            .weight(1f)
                            .fillMaxWidth()
                    )
                }
            }
            item {

                TypographyRow(
                    title = "Heading 1",
                    subTitle = "SF Pro Display/32/Bold",
                    textStyle = MainTypographyTextStyle.heading1
                )
                TypographyRow(
                    title = "Heading 2",
                    subTitle = "SF Pro Display/24/Bold",
                    textStyle = MainTypographyTextStyle.heading2
                )
                TypographyRow(
                    title = "Subheading 1",
                    subTitle = "SF Pro Display/18/SemiBold",
                    textStyle = MainTypographyTextStyle.subheading1
                )
                TypographyRow(
                    title = "Subheading 2",
                    subTitle = "SF Pro Display/16/SemiBold",
                    textStyle = MainTypographyTextStyle.subheading2
                )
                TypographyRow(
                    title = "Body Text 1",
                    subTitle = "SF Pro Display/14/SemiBold",
                    textStyle = MainTypographyTextStyle.bodyText1
                )
                TypographyRow(
                    title = "Body Text 2",
                    subTitle = "SF Pro Display/14/Regular",
                    textStyle = MainTypographyTextStyle.bodyText2
                )
                TypographyRow(
                    title = "Metadata 1",
                    subTitle = "SF Pro Display/12/Regular",
                    textStyle = MainTypographyTextStyle.metadata1
                )
                TypographyRow(
                    title = "Metadata 2",
                    subTitle = "SF Pro Display/10/Regular",
                    textStyle = MainTypographyTextStyle.metadata2
                )
                TypographyRow(
                    title = "Metadata 3",
                    subTitle = "SF Pro Display/10/SemiBold",
                    textStyle = MainTypographyTextStyle.metadata3
                )
                Row {
                    MainIcon(showBadge = false, isClickable = false)
                    MainIcon(
                        image = painterResource(id = R.drawable.meeting_avatar),
                        showBadge = false,
                        isClickable = false,
                        showBorder = false,
                        showClip = true,
                        useContentScaleCrop = true
                    )
                }
                SearchBar() {

                }
                ChipGroup()

            }
            item {
                val avatars = listOf(
                    painterResource(id = R.drawable.test_avatar),
                    painterResource(id = R.drawable.test_avatar),
                    painterResource(id = R.drawable.test_avatar),
                    painterResource(id = R.drawable.test_avatar),
                    painterResource(id = R.drawable.test_avatar),
                    painterResource(id = R.drawable.test_avatar),
                    painterResource(id = R.drawable.test_avatar)
                )
                val communityAvatar = painterResource(id = R.drawable.test_community_avatar)
                Column {
                    Spacer(modifier = Modifier.height(24.dp))
                    MainIcon(
                        showBadge = false,
                        isClickable = false,
                        image = painterResource(id = R.drawable.test_avatar),
                        showBorder = true,
                        showClip = true,
                        useContentScaleCrop = true
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        MainIcon(
                            showBadge = false,
                            isClickable = false,
                            modifier = Modifier.padding(top = 10.dp)
                        )
                        MainIcon(showBadge = true, isClickable = true, onClick = {

                        })
                    }


                }
                Spacer(modifier = Modifier.height(32.dp))
            }


        }
    }
}