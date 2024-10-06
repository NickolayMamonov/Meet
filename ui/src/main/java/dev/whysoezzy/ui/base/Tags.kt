package dev.whysoezzy.ui.base

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.whysoezzy.ui.base.text.TextBody2
import dev.whysoezzy.ui.base.text.TextHeading2
import dev.whysoezzy.ui.base.text.TextSubheading2
import dev.whysoezzy.ui.theme.MeetTheme

@Composable
internal fun LargeTag(
    text: String,
    onClick: () -> Unit,
    isClicked: Boolean,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .height(46.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable { onClick() }
            .background(
                color = when (isClicked) {
                    true -> MeetTheme.colors.brandDarkMode
                    false -> Color.White
                }
            )
            .padding(horizontal = 12.dp, vertical = 10.dp)

    ) {
        TextHeading2(
            text = text,
            color = when (isClicked) {
                true -> Color.White
                false -> MeetTheme.colors.brandDarkMode
            },
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}


@Composable
internal fun MediumTag(
    text: String,
    onClick: () -> Unit,
    isClicked: Boolean,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .height(36.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable { onClick() }
            .background(
                color = when (isClicked) {
                    true -> MeetTheme.colors.brandDarkMode
                    false -> Color.White
                }
            )
            .padding(8.dp)

    ) {
        TextSubheading2(
            text = text,
            color = when (isClicked) {
                true -> Color.White
                false -> MeetTheme.colors.brandDarkMode
            },
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }

}

@Composable
internal fun SmallTag(
    text: String,
    color: Color = Color.White,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .height(24.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color = color)
            .padding(vertical = 2.dp, horizontal = 6.dp)

    ) {
        TextBody2(
            text = text,
            color = MeetTheme.colors.brandDarkMode,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Preview
@Composable
internal fun PreviewTest() {
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(8.dp))
        LargeTag(text = "Дизайн", onClick = { /*TODO*/ }, isClicked = false)
        Spacer(modifier = Modifier.height(8.dp))
        LargeTag(text = "Дизайн", onClick = { /*TODO*/ }, isClicked = true)
        Spacer(modifier = Modifier.height(8.dp))
        MediumTag(text = "Тестирование", onClick = { /*TODO*/ }, isClicked = false)
        Spacer(modifier = Modifier.height(8.dp))
        MediumTag(text = "Тестирование", onClick = { /*TODO*/ }, isClicked = true)
        Spacer(modifier = Modifier.height(8.dp))
        SmallTag(text = "Тестирование")

    }
}