package dev.whysoezzy.ui.base.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import dev.whysoezzy.ui.theme.MeetTheme

@Composable
internal fun TextHeading1(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Color.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    lineHeight: TextUnit = TextUnit.Unspecified,
    textAlign: TextAlign? = null,

    ) {
    Text(
        text = text,
        style = MeetTheme.typography.heading1,
        color = color,
        overflow = overflow,
        lineHeight = lineHeight,
        maxLines = maxLines,
        textAlign = textAlign,
        modifier = modifier
    )
}