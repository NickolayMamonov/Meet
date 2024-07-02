package ru.wb.meetings.ui.bars

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.wb.meetings.R
import ru.wb.meetings.ui.base.MainIcon
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MainTypographyTextStyle

@Composable
fun CustomTopBar(
    onBackPressed : () -> Unit,
    showBackButton: Boolean,
    title: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(MainColorScheme.neutralWhite),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (showBackButton) {
            MainIcon(
                image = painterResource(id = R.drawable.back_button),
                showBadge = false,
                isClickable = true,
                onClick = onBackPressed
            )

        }
        Text(
            text = title,
            style = MainTypographyTextStyle.subheading1,
            modifier = Modifier.padding(start = 12.dp)
        )
    }
}