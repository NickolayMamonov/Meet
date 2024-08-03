package dev.whysoezzy.ui.base

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.theme.MeetTheme

@Composable
internal fun UserAvatar(
    image: String? = null,
    size: Dp,
    isBadge: Boolean = false,
    onClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.BottomEnd,
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(size)
                .clip(CircleShape)
                .clickable { onClick?.invoke() }
                .background(MeetTheme.colors.neutralSecondaryBackground)
        ) {
            AsyncImage(
                model = image,
                contentDescription = "User Avatar",
                alignment = Alignment.Center,
                placeholder = painterResource(id = R.drawable.icon_person),
                error = painterResource(id = R.drawable.icon_person),
                modifier = modifier.size(size / 2)
            )
        }
        if (isBadge) {
            Image(
                painter = painterResource(id = R.drawable.icon_badge),
                contentDescription = null,
                modifier = Modifier
                    .offset((-8).dp, (-8).dp)
            )

        }
    }


}
