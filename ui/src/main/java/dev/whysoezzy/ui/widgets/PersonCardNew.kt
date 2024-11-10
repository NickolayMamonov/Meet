package dev.whysoezzy.ui.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.whysoezzy.ui.base.CircleAvatarNew
import dev.whysoezzy.ui.base.CustomTag
import dev.whysoezzy.ui.base.TagSize
import dev.whysoezzy.ui.theme.LocalColorScheme

@Composable
fun PersonCard(
    name: String,
    tag: String,
    imageUrl: String,
    isSubscribed: Boolean = false,
    onSubscribeClick: ((Boolean) -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    val colorScheme = LocalColorScheme.current

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .padding(12.dp)
            .width(64.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CircleAvatarNew(
            imageUrl = imageUrl,
            size = 64.dp
        )
        Text(
            text = name,
            color = colorScheme.neutralBody,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        CustomTag(
            text = tag,
            size = TagSize.SMALL,
            selected = isSubscribed,
        )
    }
}

@Preview
@Composable
fun PersonCardNewPreview() {
    var isSubscribed by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Простая карточка без возможности подписки
        PersonCard(
            name = "John Doe",
            tag = "Designer",
            imageUrl = "https://picsum.photos/200"
        )

        // Карточка с длинным именем
        PersonCard(
            name = "John Doe with a very long name that should be ellipsized",
            tag = "UX Designer",
            imageUrl = "https://picsum.photos/201"
        )

        // Карточка с возможностью подписки
        PersonCard(
            name = "Jane Smith",
            tag = "Developer",
            imageUrl = "https://picsum.photos/202",
            isSubscribed = isSubscribed,
            onSubscribeClick = { newState ->
                isSubscribed = newState
            }
        )

        // Карточка без изображения
        PersonCard(
            name = "Alex Johnson",
            tag = "Manager",
            imageUrl = "",
            isSubscribed = false
        )
    }
}