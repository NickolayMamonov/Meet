package dev.whysoezzy.ui.screens.events.detail.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import dev.whysoezzy.ui.R
import dev.whysoezzy.ui.base.buttons.CustomButton
import dev.whysoezzy.ui.base.buttons.CustomOutlinedButton

@Composable
fun EventButton(buttonPressed: Boolean, setButtonPressed: (Boolean) -> Unit) {
    when {
        !buttonPressed -> {
            CustomButton(
                text = stringResource(R.string.go_to_event),
                onClick = { setButtonPressed(true) },
                modifier = Modifier.fillMaxWidth()
            )
        }

        else -> {
            CustomOutlinedButton(
                text = stringResource(R.string.go_another_time),
                onClick = { setButtonPressed(false) },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}