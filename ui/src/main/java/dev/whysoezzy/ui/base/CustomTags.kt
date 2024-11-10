package dev.whysoezzy.ui.base

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.whysoezzy.ui.base.text.TextBody2
import dev.whysoezzy.ui.base.text.TextHeading2
import dev.whysoezzy.ui.base.text.TextSubheading2
import dev.whysoezzy.ui.theme.LocalColorScheme

enum class TagSize {
    SMALL,
    MEDIUM,
    BIG
}

@Composable
fun CustomTag(
    text: String,
    size: TagSize,
    selected: Boolean = false,
    isClickable: Boolean = false,
    onClick: () -> Unit = {}
) {
    val colorScheme = LocalColorScheme.current

    val backgroundColor = when {
        selected -> colorScheme.brandDefault
        else -> colorScheme.neutralLine
    }

    val textColor = when {
        selected -> colorScheme.neutralWhite
        else -> colorScheme.brandDefault
    }


    val tagModifier = when (size) {
        TagSize.SMALL -> Modifier
            .height(22.dp)

        TagSize.MEDIUM -> Modifier
            .height(35.dp)

        TagSize.BIG -> Modifier
            .height(46.dp)

    }

    Box(
        modifier = Modifier
            .then(tagModifier)
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .then(
                if (isClickable && (size == TagSize.MEDIUM || size == TagSize.BIG)) {
                    Modifier.clickable(onClick = onClick)
                } else {
                    Modifier
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        when (size) {
            TagSize.BIG -> TextHeading2(
                text = text,
                color = textColor,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(
                        start = 12.dp,
                        end = 12.dp,
                        top = 10.dp,
                        bottom = 10.dp
                    )
            )

            TagSize.MEDIUM -> TextSubheading2(
                text = text,
                color = textColor,
                fontWeight = FontWeight.Medium,

                modifier = Modifier
                    .padding(8.dp)
            )

            TagSize.SMALL -> TextBody2(
                text = text,
                color = textColor,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(
                        start = 6.dp,
                        end = 6.dp,
                        top = 2.dp,
                        bottom = 3.dp
                    )
            )
        }
    }
}

@Preview
@Composable
fun TagsPreview() {
    var selectedSmall by remember { mutableStateOf(false) }
    var selectedMedium by remember { mutableStateOf(false) }
    var selectedBig by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Small tags
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CustomTag(
                text = "Тестирование",
                size = TagSize.SMALL
            )
            CustomTag(
                text = "Тестирование",
                size = TagSize.SMALL,
                selected = true
            )
        }

        // Medium tags
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CustomTag(
                text = "Тестирование",
                size = TagSize.MEDIUM,
                isClickable = true,
                selected = selectedMedium,
                onClick = { selectedMedium = !selectedMedium }
            )
            CustomTag(
                text = "Тестирование",
                size = TagSize.MEDIUM,
                isClickable = false,
                selected = true
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CustomTag(
                text = "Дизайн",
                size = TagSize.BIG,
                isClickable = true,
                selected = selectedBig,
                onClick = { selectedBig = !selectedBig }
            )
            CustomTag(
                text = "Дизайн",
                size = TagSize.BIG,
                isClickable = false,
                selected = true
            )
        }
    }
}