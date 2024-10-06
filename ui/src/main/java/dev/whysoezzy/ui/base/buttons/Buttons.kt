package dev.whysoezzy.ui.base.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.whysoezzy.ui.theme.MeetTheme
import dev.whysoezzy.ui.theme.PrimaryGradient
import dev.whysoezzy.ui.theme.SecondaryGradient

@Composable
fun MainButton(
    modifier: Modifier = Modifier,
    text: String,
    btnState: ButtonState = ButtonState.ACTIVE,
    onClick: () -> Unit
) {
    val backgroundColor = when (btnState) {
        ButtonState.ACTIVE -> {
            modifier
                .background(brush = PrimaryGradient)
                .clickable { onClick() }
        }

        ButtonState.LOADING -> {
            modifier.background(brush = PrimaryGradient)
        }

        ButtonState.DISABLED -> {
            modifier.background(color = MeetTheme.colors.brandBackground)
        }
    }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .then(backgroundColor)
            .padding(12.dp),
        contentAlignment = Alignment.Center
    ) {
        when (btnState) {
            ButtonState.ACTIVE -> {
                Text(
                    text = text,
                    style = MeetTheme.typography.subheading1,
                    color = Color.White
                )
            }

            ButtonState.LOADING -> {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    strokeWidth = 2.dp
                )
            }

            ButtonState.DISABLED -> {
                Text(
                    text = text,
                    style = MeetTheme.typography.subheading1,
                    color = Color.Gray
                )
            }
        }

    }
}

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    text: String,
    btnState: ButtonState = ButtonState.ACTIVE,
    onClick: () -> Unit
) {
    val backgroundColor = when (btnState) {
        ButtonState.ACTIVE -> {
            modifier
                .background(brush = SecondaryGradient)
                .clickable { onClick() }
        }

        ButtonState.LOADING -> {
            modifier.background(brush = SecondaryGradient)
        }

        ButtonState.DISABLED -> {
            modifier.background(color = MeetTheme.colors.brandBackground)
        }
    }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .then(backgroundColor)
            .padding(12.dp),
        contentAlignment = Alignment.Center
    ) {
        when (btnState) {
            ButtonState.ACTIVE -> {
                Text(
                    text = text,
                    style = MeetTheme.typography.subheading1,
                    color = Color.White
                )
            }

            ButtonState.LOADING -> {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    strokeWidth = 2.dp
                )
            }

            ButtonState.DISABLED -> {
                Text(
                    text = text,
                    style = MeetTheme.typography.subheading1,
                    color = Color.Gray
                )
            }
        }

    }
}

enum class ButtonState {
    ACTIVE, LOADING, DISABLED
}

@Preview
@Composable
private fun PreviewButton() {
    val text = "Оплатить"
    var btnState1 by remember { mutableStateOf(ButtonState.ACTIVE) }
    var btnState2 by remember { mutableStateOf(ButtonState.ACTIVE) }
    var btnState3 by remember { mutableStateOf(ButtonState.ACTIVE) }


    Column {
        MainButton(
            text = text,
            btnState = btnState1,
            onClick = { btnState1 = ButtonState.LOADING }
        )
        MainButton(
            text = text,
            btnState = btnState2,
            onClick = { btnState2 = ButtonState.DISABLED }
        )
        SecondaryButton(
            text = text,
            btnState = btnState3,
            onClick = { btnState3 = ButtonState.LOADING }
        )

    }

}