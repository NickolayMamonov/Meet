package dev.whysoezzy.ui.base

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.theme.LocalColorScheme

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

@Composable
fun CircleAvatarNew(
    imageUrl: String,
    modifier: Modifier = Modifier,
    size: Dp = 40.dp,
    placeholder: @Composable (() -> Unit)? = null,
    onClick: (() -> Unit)? = null
) {
    val colorScheme = LocalColorScheme.current

    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .then(
                if (onClick != null) {
                    Modifier.clickable(onClick = onClick)
                } else {
                    Modifier
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        if (imageUrl.isNotEmpty()) {
            AsyncImage(
                model = imageUrl,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        } else {
            placeholder?.invoke() ?: Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorScheme.neutralLine),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    tint = colorScheme.neutralWeak,
                    modifier = Modifier.size(size * 0.6f)
                )
            }
        }
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

@Preview
@Composable
fun CircleAvatarNewPreview() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Маленький аватар с изображением
        CircleAvatarNew(
            imageUrl = "https://picsum.photos/200",
            size = 40.dp
        )

        // Средний аватар без изображения
        CircleAvatarNew(
            imageUrl = "",
            size = 64.dp
        )

        // Большой аватар с изображением и обработкой клика
        CircleAvatarNew(
            imageUrl = "https://picsum.photos/200",
            size = 80.dp,
            onClick = { /* обработка клика */ }
        )

        // Аватар с кастомным плейсхолдером
        CircleAvatarNew(
            imageUrl = "",
            size = 56.dp,
            placeholder = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(colorScheme.onPrimary),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "AB",
                        color = colorScheme.onPrimary,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        )
    }
}