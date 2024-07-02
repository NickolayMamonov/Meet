package ru.wb.meetings.ui.events

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import ru.wb.meetings.ui.rows.OverlappingRow

@Composable
fun EventsRow(avatars: List<Painter>, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.CenterStart
    ) {


        if (avatars.isEmpty()) {
            Text(text = "Not liked yet!")
        } else {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                OverlappingRow(avatars = avatars, overlappingPercentage = 0.35f)

            }
        }

    }

}