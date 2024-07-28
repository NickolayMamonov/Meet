package dev.whysoezzy.ui.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.rows.OverlappingRow

@Composable
fun EventsRow(avatars: List<String>, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.CenterStart
    ) {
        when {
            avatars.isEmpty() -> {
                Text(text = stringResource(R.string.not_liked_yet))
            }
            else -> {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OverlappingRow(avatars = avatars, overlappingPercentage = 0.35f)
                }
            }
        }
    }
}