package dev.whysoezzy.ui.widgets

import CommunityCardNew
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.whysoezzy.ui.theme.MeetTheme


data class CommunityData(
    val id: String,
    val imageUrl: String,
    val title: String,
    val isSubscribed: Boolean,
    val onSubscribeClick: (Boolean) -> Unit,
)

data class EventData(
    val id: String,
    val imageUrl: String,
    val title: String,
    val subtitle: String,
    val tags: List<TagData>
)

@Composable
fun EventCarousel(
    events: List<EventData>,
    cardType: CardType,
    modifier: Modifier = Modifier
) {
    val cardHeight = when (cardType) {
        CardType.THIN -> 272.dp
        CardType.WIDE -> 300.dp
    }

    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(events) { event ->
            Box(
                modifier = Modifier.height(cardHeight)
            ) {
                EventCard(
                    imageUrl = event.imageUrl,
                    title = event.title,
                    subtitle = event.subtitle,
                    tags = event.tags,
                    cardType = cardType
                )
            }
        }
    }
}

@Composable
fun CommunityCarousel(
    communities: List<CommunityData>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(communities) { community ->
            Box(
                modifier = Modifier.height(166.dp)
            ) {
                CommunityCardNew(
                    imageUrl = community.imageUrl,
                    title = community.title,
                    isSubscribed = community.isSubscribed,
                    onSubscribeClick = community.onSubscribeClick
                )
            }
        }
    }
}


@Preview
@Composable
fun EventCarouselPreview() {
    var selectedTags by remember { mutableStateOf(setOf<String>()) }
    var communitySubscriptions by remember {
        mutableStateOf(
            mapOf(
                "1" to false,
                "2" to true
            )
        )
    }

    val events = listOf(
        EventData(
            id = "1",
            imageUrl = "https://picsum.photos/320/180",
            title = "Summer Music Festival 2024",
            subtitle = "10 августа · Кожевенная линия, 40",
            tags = listOf(
                TagData(
                    text = "Music",
                    isSelected = selectedTags.contains("Music"),
                    isClickable = true,
                    onClick = { isSelected ->
                        selectedTags = if (isSelected) {
                            selectedTags + "Music"
                        } else {
                            selectedTags - "Music"
                        }
                    }
                ),
                TagData("Festival"),
                TagData("Summer")
            )
        ),
        EventData(
            id = "2",
            imageUrl = "https://picsum.photos/320/181",
            title = "Tech Conference: AI & Future",
            subtitle = "10 августа · Кожевенная линия, 40",
            tags = listOf(
                TagData("Tech"),
                TagData("AI"),
                TagData("Conference")
            )
        ),
        EventData(
            id = "3",
            imageUrl = "https://picsum.photos/320/182",
            title = "Art Exhibition: Modern Perspectives with a very long title that should be truncated",
            subtitle = "10 августа · Кожевенная линия, 40",
            tags = listOf(
                TagData("Art"),
                TagData("Exhibition"),
                TagData("Modern"),
                TagData("Contemporary"),
                TagData("Gallery")
            )
        )
    )
    val communityItems = listOf(
        CommunityData(
            id = "1",
            imageUrl = "https://picsum.photos/320/180",
            title = "Art Exhibition: Modern Perspectives with a very long title that should be truncated",
            isSubscribed = communitySubscriptions["1"] ?: false,
            onSubscribeClick = { isSubscribed ->
                communitySubscriptions = communitySubscriptions + ("1" to isSubscribed)
            }
        ),
        CommunityData(
            id = "2",
            imageUrl = "https://picsum.photos/320/180",
            title = "Art Exhibition: Modern Perspectives with a very long title that should be truncated",
            isSubscribed = communitySubscriptions["2"] ?: true,
            onSubscribeClick = { isSubscribed ->
                communitySubscriptions = communitySubscriptions + ("2" to isSubscribed)
            }
        )
    )
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MeetTheme.colors.neutralSecondaryBackground)
                .padding(vertical = 16.dp)
        ) {
            EventCarousel(events = events, cardType = CardType.THIN)
        }
        Spacer(modifier = Modifier.height(124.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MeetTheme.colors.neutralSecondaryBackground)
                .padding(vertical = 16.dp)
        ) {
            CommunityCarousel(communities = communityItems)
        }
    }
}