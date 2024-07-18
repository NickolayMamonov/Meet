package ru.wb.meetings.ui.rows

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import ru.wb.meetings.ui.base.MainNetworkIcon
import ru.wb.meetings.ui.base.text.TextBody1
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MainTypographyTextStyle
import ru.wb.meetings.ui.theme.MeetTheme

@Composable
fun OverlappingRow(
    avatars: List<String>,
    modifier: Modifier = Modifier,
    overlappingPercentage: Float,
) {

    val factor = (1 - overlappingPercentage)

    Layout(
        modifier = modifier,
        content = {
            avatars.take(5).forEach { avatar ->
                MainNetworkIcon(
                    image = avatar,
                    showBadge = false,
                    isClickable = false,
                    showBorder = true,
                    showClip = true,
                    useContentScaleCrop = true
                )
            }
            if (avatars.size > 5) {
                TextBody1(
                    text = "+${avatars.size - 5}",
                    color = MeetTheme.colors.neutralActive,
                    modifier = Modifier.padding(start = 28.dp, top = 16.dp)
                )
            }

        },
        measurePolicy = { measurables, constraints ->
            val placeables = measurables.map { it.measure(constraints) }
            val widthsExceptFirst = placeables.subList(1, placeables.size).sumOf { it.width }
            val firstWidth = placeables.getOrNull(0)?.width ?: 0
            val width = (widthsExceptFirst * factor + firstWidth).toInt()
            val height = placeables.maxOf { it.height }
            layout(width, height) {
                var x = 0
                placeables.forEachIndexed { index, placeable ->
                    placeable.placeRelative(
                        x, 0, (placeables.size - index).toFloat()
                    )
                    x += (placeable.width * factor).toInt()
                }
            }
        }
    )
}