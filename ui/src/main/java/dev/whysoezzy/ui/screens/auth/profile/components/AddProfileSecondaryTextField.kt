package dev.whysoezzy.ui.screens.auth.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.base.text.TextBody1
import dev.whysoezzy.ui.screens.auth.profile.AddProfileViewModel
import dev.whysoezzy.ui.theme.MeetTheme

@Composable
internal fun AddProfileSecondaryTextField(
    lastName: String,
    viewModel: AddProfileViewModel
) {
    Box(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(MeetTheme.colors.neutralSecondaryBackground)

    ) {
        BasicTextField(
            value = lastName,
            onValueChange = viewModel::updateLastName,
            singleLine = true,
            textStyle = MeetTheme.typography.bodyText1,
            cursorBrush = SolidColor(Color.Transparent),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            decorationBox = { innerTextField ->
                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .fillMaxWidth()
                ) {
                    if (lastName.isEmpty()) {
                        TextBody1(
                            text = stringResource(R.string.surname_optionally),
                            color = MeetTheme.colors.neutralWeak
                        )
                    }
                    innerTextField()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        )
    }
}