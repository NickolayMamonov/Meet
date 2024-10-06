package dev.whysoezzy.ui.base

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.whysoezzy.ui.R

@Composable
internal fun CircleAvatar(
    modifier: Modifier = Modifier,
    size: Dp,
    image: String?,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        AsyncImage(
            model = image,
            contentDescription = "User Avatar",
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.test_avatar),
            error = painterResource(id = R.drawable.test_avatar),
            modifier = modifier
                .size(size)
                .clip(CircleShape)
        )
    }
}

@Preview
@Composable
fun CircleAvatarPreview() {
    CircleAvatar(
        size = 200.dp,
        image = null
    )
}