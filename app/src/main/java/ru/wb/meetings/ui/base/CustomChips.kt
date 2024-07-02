package ru.wb.meetings.ui.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MainTypographyTextStyle
import ru.wb.meetings.ui.theme.SFProDisplayFontFamily

@Composable
fun ChipGroup() {
    val chipData = listOf(
        "Kotlin",
        "Junior",
        "Moscow"
    )
    LazyRow(modifier = Modifier.padding(top = 8.dp)) {
        chipData.forEach {
            item {
                CustomChip(text = it)
                Spacer(modifier = Modifier.width(4.dp))
            }
        }

    }
}

@Composable
fun CustomChip(text: String, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .background(MainColorScheme.brandBackground, RoundedCornerShape(33.dp))
    ) {
        Text(
            text = text,
            color = MainColorScheme.brandDark,
            style = MainTypographyTextStyle.metadata3,
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 4.dp)
        )
    }

}
