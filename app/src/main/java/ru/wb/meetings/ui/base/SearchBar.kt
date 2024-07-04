package ru.wb.meetings.ui.base

import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import ru.wb.meetings.R
import ru.wb.meetings.ui.theme.MainColorScheme


@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit = {}
) {
    val (text, setText) = remember { mutableStateOf("") }
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()
    val focusedColor = if (isFocused) MainColorScheme.neutralActive else MainColorScheme.neutralLine
    val borderColor = if (isFocused) MainColorScheme.neutralActive else MainColorScheme.neutralLine
    val textColor = if (isFocused) MainColorScheme.neutralBody else MainColorScheme.neutralWeak

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(1.dp, borderColor, RoundedCornerShape(13))
    ) {
        TextField(
            value = text,
            onValueChange = setText,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search,
            ),
            maxLines = 1,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search Icon",
                    tint = focusedColor
                )
            },
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearch(text)
                }
            ),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                focusedContainerColor = MainColorScheme.neutralWhite,
                unfocusedContainerColor = MainColorScheme.neutralWhite,
                focusedLabelColor = focusedColor,
                unfocusedLabelColor = textColor
            ),
            interactionSource = interactionSource,
            placeholder = {
                Text(
                    stringResource(R.string.search),
                    color = textColor
                )
            }
        )
    }
}