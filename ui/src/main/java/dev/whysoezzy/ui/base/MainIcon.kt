package dev.whysoezzy.ui.base

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.theme.MeetTheme

@Composable
internal fun MainIcon(
    image: Painter? = null,
    showBadge: Boolean = false,
    onClick: (() -> Unit)? = null,
    isClickable: Boolean = false,
    showBorder: Boolean = false,
    showClip: Boolean = false,
    clipPercent: Int = 35,
    sizeIcon: Dp = 48.dp,
    useContentScaleCrop: Boolean = false,
    modifier: Modifier = Modifier
        .let { if (showClip) it.clip(RoundedCornerShape(clipPercent)) else it }
        .let {
            if (showBorder) it.border(
                2.dp,
                MeetTheme.colors.neutralLine,
                shape = RoundedCornerShape(35)
            ) else it
        }
) {
    Box(
        modifier =
        if (isClickable) modifier
            .clickable { onClick?.invoke() }
            .padding(10.dp)
        else modifier

    ) {
        Image(
            painter = image ?: painterResource(id = R.drawable.icon_person),
            contentDescription = "Default Icon",
            contentScale = if (useContentScaleCrop) ContentScale.Crop else ContentScale.Fit,
            modifier = Modifier
                .size(sizeIcon)


        )
        if (showBadge) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .size(16.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_badge),
                    contentDescription = "Add icon",
                    modifier = Modifier
                        .offset((8.dp), (12).dp)
                        .size(8.dp)


                )

            }
        }

    }
}