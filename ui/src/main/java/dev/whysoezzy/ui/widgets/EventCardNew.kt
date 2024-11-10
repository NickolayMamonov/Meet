package dev.whysoezzy.ui.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import dev.whysoezzy.ui.base.CustomTag
import dev.whysoezzy.ui.base.TagSize
import dev.whysoezzy.ui.theme.LocalColorScheme

enum class CardType {
    THIN,
    WIDE
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun EventCard(
    imageUrl: String,
    title: String,
    subtitle: String,
    tags: List<TagData>,
    cardType: CardType,
    modifier: Modifier = Modifier
) {
    val colorScheme = LocalColorScheme.current

    val cardWidth = when (cardType) {
        CardType.THIN -> 212.dp
        CardType.WIDE -> 320.dp
    }

    val imageHeight = when (cardType) {
        CardType.THIN -> 148.dp
        CardType.WIDE -> 180.dp
    }

    Column(
        modifier = modifier
            .width(cardWidth)
            .clip(RoundedCornerShape(16.dp)),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Изображение
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(imageHeight)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )

        // Текст
        Text(
            text = title,
            color = colorScheme.neutralBody,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            tags.forEach { tagData ->
                CustomTag(
                    text = tagData.text,
                    size = TagSize.SMALL,
                    selected = tagData.isSelected,
                    isClickable = tagData.isClickable,
                    onClick = { tagData.onClick?.invoke(!tagData.isSelected) }
                )
            }
        }

    }
}

data class TagData(
    val text: String,
    val isSelected: Boolean = false,
    val isClickable: Boolean = false,
    val onClick: ((Boolean) -> Unit)? = null
)


@Preview
@Composable
fun CardPreview() {
    var selectedTags by remember { mutableStateOf(setOf<String>()) }

    val sampleTags = listOf(
        TagData(
            text = "Tag 1",
            isSelected = selectedTags.contains("Tag 1"),
            isClickable = true,
            onClick = { isSelected ->
                selectedTags = if (isSelected) {
                    selectedTags + "Tag 1"
                } else {
                    selectedTags - "Tag 1"
                }
            }
        ),
        TagData(text = "Long Tag 2"),
        TagData(
            text = "Interactive Tag",
            isSelected = selectedTags.contains("Interactive Tag"),
            isClickable = true,
            onClick = { isSelected ->
                selectedTags = if (isSelected) {
                    selectedTags + "Interactive Tag"
                } else {
                    selectedTags - "Interactive Tag"
                }
            }
        ),
        TagData(text = "Very Long Tag 4"),
        TagData(text = "Tag 5"),
        TagData(text = "Another Tag")
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        EventCard(
            imageUrl = "https://picsum.photos/181/181",
            title = "This is a wide card with a very long title that should wrap to two lines and then show ellipsis if it's longer",
            subtitle = "10 августа · Кожевенная линия, 40",
            tags = sampleTags,
            cardType = CardType.WIDE
        )

        // Thin card
        EventCard(
            imageUrl = "https://picsum.photos/212/212",
            title = "This is a thin card with a very long title that should wrap to two lines",
            subtitle = "10 августа · Кожевенная линия, 40",
            tags = sampleTags,
            cardType = CardType.THIN
        )
    }
}