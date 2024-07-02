package ru.wb.meetings.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import ru.wb.meetings.R
import ru.wb.meetings.ui.base.ButtonColumns
import ru.wb.meetings.ui.base.ButtonProperties
import ru.wb.meetings.ui.base.ChipGroup
import ru.wb.meetings.ui.base.MainIcon
import ru.wb.meetings.ui.base.SearchBar
import ru.wb.meetings.ui.rows.TypographyRow
import ru.wb.meetings.ui.theme.MainTypographyTextStyle

@Composable
fun DeveloperScreen(){
    val buttons1 = listOf(
                    ButtonProperties("Button 1", { /*TODO*/ }, true),
                    ButtonProperties("Button 2", { /*TODO*/ }, true),
                    ButtonProperties("Button 3", { /*TODO*/ }, false)
                )
                val buttons2 = listOf(
                    ButtonProperties("Button 4", { /*TODO*/ }, true),
                    ButtonProperties("Button 5", { /*TODO*/ }, true),
                    ButtonProperties("Button 6", { /*TODO*/ }, false)
                )
                val buttons3 = listOf(
                    ButtonProperties("Button 7", { /*TODO*/ }, true),
                    ButtonProperties("Button 8", { /*TODO*/ }, true),
                    ButtonProperties("Button 9", { /*TODO*/ }, false)
                )
                Column {
                    ButtonColumns(
                        buttons1,
                        buttons2,
                        buttons3,
                    )
                    LazyColumn {
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
                                MainIcon(image = painterResource(id = R.drawable.meeting_avatar), showBadge = false, isClickable = false, showBorder = false, showClip = true, useContentScaleCrop = true)
                            }
                            SearchBar()
                            ChipGroup()

                        }

                    }
                }
}