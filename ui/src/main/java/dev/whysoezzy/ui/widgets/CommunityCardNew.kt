import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import dev.whysoezzy.ui.base.buttons.CustomSubscribeButton
import dev.whysoezzy.ui.theme.LocalColorScheme

@Composable
fun CommunityCardNew(
    imageUrl: String,
    title: String,
    isSubscribed: Boolean,
    onSubscribeClick: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val colorScheme = LocalColorScheme.current
    Column(
        modifier = modifier
            .width(104.dp)
            .clip(RoundedCornerShape(16.dp)),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier
                .size(104.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )
        Text(
            text = title,
            color = colorScheme.neutralBody,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        CustomSubscribeButton(
            selected = isSubscribed,
            onSelectedChange = onSubscribeClick,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun CardPreview() {
    var isSubscribed by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CommunityCardNew(
            imageUrl = "https://picsum.photos/200",
            title = "Короткий текст",
            isSubscribed = false,
            onSubscribeClick = { }
        )
        CommunityCardNew(
            imageUrl = "https://picsum.photos/200",
            title = "Очень длинный текст, который не помещается в три строки и должен быть обрезан с добавлением многоточия в конце для лучшего визуального восприятия",
            isSubscribed = true,
            onSubscribeClick = { }
        )
        CommunityCardNew(
            imageUrl = "https://picsum.photos/200",
            title = "Карточка с рабочей кнопкой подписки",
            isSubscribed = isSubscribed,
            onSubscribeClick = { isSubscribed = it }
        )
    }
}