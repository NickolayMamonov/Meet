package ru.wb.meetings.ui.base

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import ru.wb.meetings.R
import ru.wb.meetings.ui.theme.MeetTheme

@Composable
fun UserAvatar(
    image: String? = null,
    size: Dp,
    onClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
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
            modifier = modifier.size(size/2)
        )
    }

}
