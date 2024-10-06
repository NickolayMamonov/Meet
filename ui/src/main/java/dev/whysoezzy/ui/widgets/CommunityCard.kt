package dev.whysoezzy.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.base.text.TextBody1
import dev.whysoezzy.ui.models.CommunityModelUI
import dev.whysoezzy.ui.theme.MeetTheme

@Composable
internal fun CommunityCard(
    modifier: Modifier = Modifier,
    community: CommunityModelUI,
    onClick: () -> Unit,
    isClicked: Boolean = false,
    size: Dp = 104.dp,
) {
    Box(modifier = modifier) {
        Column {
            AsyncImage(
                model = community.image,
                contentDescription = null,
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.test_community_avatar),
                error = painterResource(id = R.drawable.test_community_avatar),
                modifier = Modifier
                    .size(size)
                    .clip(RoundedCornerShape(16.dp))
            )
            TextBody1(
                text = community.text,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.width(size)
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(size)
                    .height(36.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .clickable { onClick() }
                    .background(
                        color = when (isClicked) {
                            true -> MeetTheme.colors.brandDarkMode
                            false -> MeetTheme.colors.neutralSecondaryBackground
                        }
                    )) {
                when (isClicked) {
                    true -> {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_accept_community),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }

                    false -> {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_plus_community),
                            contentDescription = null,
                            tint = MeetTheme.colors.brandDarkMode
                        )
                    }
                }

            }

        }

    }
}

@Preview
@Composable
fun CommunityCardPreview() {
    CommunityCard(
        community = CommunityModelUI(
            id = "1",
            image = null,
            text = "Супер тестировщики"
        ),
        isClicked = false,
        onClick = {}
    )
}