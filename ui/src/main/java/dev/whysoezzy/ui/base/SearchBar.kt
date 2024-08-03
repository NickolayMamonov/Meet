package dev.whysoezzy.ui.base

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.theme.MeetTheme


@Composable
internal fun SearchBar(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp, vertical = 8.dp),
    backgroundColor: Color = MeetTheme.colors.neutralSecondaryBackground,
    activeContentColor: Color = MeetTheme.colors.neutralActive,
    contentColor: Color = MeetTheme.colors.neutralDisabled,
    onSearch: (String) -> Unit
) {
    var searchText by rememberSaveable { mutableStateOf("") }
    var isActive by remember { mutableStateOf(false) }
    BasicTextField(value = searchText,
        onValueChange = {
            searchText = it
            onSearch(it)
        },
        singleLine = true,
        textStyle = MeetTheme.typography.bodyText1,

        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 36.dp)
                    .background(backgroundColor),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search",
                    tint = if (searchText.isEmpty()) contentColor else activeContentColor,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Box(modifier = Modifier.weight(1f)) {
                    if (searchText.isEmpty()) {
                        Text(
                            stringResource(id = R.string.search),
                            style = MeetTheme.typography.bodyText1,
                            color = contentColor
                        )
                    }
                    innerTextField()
                }
            }
        },
        modifier = modifier
            .onFocusChanged { focusState ->
                isActive = focusState.isFocused
            }
            .clip(shape = RoundedCornerShape(4.dp))
            .border(
                1.dp,
                when {
                    isActive -> {
                        MeetTheme.colors.neutralLine
                    }

                    else -> {
                        MeetTheme.colors.neutralSecondaryBackground
                    }
                }
            )
    )
}