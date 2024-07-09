package ru.wb.meetings.ui.base

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import ru.wb.meetings.R
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MainTypographyTextStyle


//@Composable
//fun SearchBar(
//    modifier: Modifier = Modifier,
//    onSearch: (String) -> Unit = {}
//) {
//    val (text, setText) = remember { mutableStateOf("") }
//    val interactionSource = remember { MutableInteractionSource() }
//    val isFocused by interactionSource.collectIsFocusedAsState()
//    val focusedColor = if (isFocused) MainColorScheme.neutralActive else MainColorScheme.neutralLine
//    val borderColor = if (isFocused) MainColorScheme.neutralActive else MainColorScheme.neutralLine
//    val textColor = if (isFocused) MainColorScheme.neutralBody else MainColorScheme.neutralWeak
//
//    Box(
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//            .border(1.dp, borderColor, RoundedCornerShape(13))
//    ) {
//        TextField(
//            value = text,
//            onValueChange = setText,
//            keyboardOptions = KeyboardOptions(
//                keyboardType = KeyboardType.Text,
//                imeAction = ImeAction.Search,
//            ),
//            maxLines = 1,
//            leadingIcon = {
//                Icon(
//                    imageVector = Icons.Filled.Search,
//                    contentDescription = "Search Icon",
//                    tint = focusedColor
//                )
//            },
//            keyboardActions = KeyboardActions(
//                onSearch = {
//                    onSearch(text)
//                }
//            ),
//            colors = TextFieldDefaults.colors(
//                focusedIndicatorColor = Color.Transparent,
//                unfocusedIndicatorColor = Color.Transparent,
//                disabledIndicatorColor = Color.Transparent,
//                focusedContainerColor = MainColorScheme.neutralWhite,
//                unfocusedContainerColor = MainColorScheme.neutralWhite,
//                focusedLabelColor = focusedColor,
//                unfocusedLabelColor = textColor
//            ),
//            interactionSource = interactionSource,
//            placeholder = {
//                Text(
//                    stringResource(R.string.search),
//                    color = textColor
//                )
//            }
//        )
//    }
//}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MainColorScheme.neutralSecondaryBackground,
    activeContentColor: Color = MainColorScheme.neutralActive,
    contentColor: Color = MainColorScheme.neutralDisabled,
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
        textStyle = MainTypographyTextStyle.bodyText1,

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
                            style = MainTypographyTextStyle.bodyText1,
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
            .clip(shape =  RoundedCornerShape(4.dp))
            .border(
                1.dp,
                if (isActive) {
                    MainColorScheme.neutralLine
                } else {

                    MainColorScheme.neutralSecondaryBackground
                }
            )


    )
}