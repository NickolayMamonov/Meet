package ru.wb.meetings.ui.rows

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MainTypographyTextStyle
import ru.wb.meetings.ui.theme.SFProDisplayFontFamily

@Composable
fun TypographyRow(
    title: String,
    subTitle: String,
    textStyle: TextStyle,
    modifier: Modifier = Modifier,
) {
    val text = "The quick brown fox jumps over the lazy dog"
    LazyRow(
        modifier = modifier
    ) {
        item {
            Column(
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .widthIn(180.dp)
            ) {

                Text(
                    text = title,
                    style = MainTypographyTextStyle.subheading2,
                    fontSize = MainTypographyTextStyle.subheading2.fontSize,
                    maxLines = 1,
                    color = MainColorScheme.neutralActive
                )
                Text(
                    text = subTitle,
                    style = MainTypographyTextStyle.bodyText2,
                    fontSize = MainTypographyTextStyle.bodyText2.fontSize,
                    maxLines = 1,
                    color = MainColorScheme.neutralWeak
                )

            }
            Text(
                text = text,
                style = textStyle,
                color = MainColorScheme.neutralActive,
                maxLines = 1,
                modifier = Modifier.padding(8.dp)
            )
        }

    }
}
