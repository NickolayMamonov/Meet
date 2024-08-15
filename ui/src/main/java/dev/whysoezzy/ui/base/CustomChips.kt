package dev.whysoezzy.ui.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.whysoezzy.ui.base.text.TextMetadata3
import dev.whysoezzy.ui.theme.MeetTheme

@Composable
internal fun ChipGroup(chipData: List<String>) {
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
            .background(MeetTheme.colors.brandBackground, RoundedCornerShape(33.dp))
    ) {
        TextMetadata3(
            text = text,
            color = MeetTheme.colors.brandDark,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        )
    }
}

