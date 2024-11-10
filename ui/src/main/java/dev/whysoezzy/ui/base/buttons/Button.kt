package dev.whysoezzy.ui.base.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.whysoezzy.ui.theme.LocalColorScheme
import dev.whysoezzy.ui.theme.PrimaryGradient
import dev.whysoezzy.ui.theme.SecondaryGradient

enum class CustomButtonState {
    PRIMARY,
    SECONDARY,
    LOADING,
    DISABLED
}

@Composable
fun CustomButton(
    text: String,
    state: CustomButtonState = CustomButtonState.PRIMARY,
    onClick: () -> Unit = {}
) {
    val colorScheme = LocalColorScheme.current


    Box(
        modifier = Modifier
            .width(343.dp)
            .height(56.dp)
            .clip(RoundedCornerShape(16.dp))
            .then(
                when (state) {
                    CustomButtonState.PRIMARY, CustomButtonState.LOADING -> Modifier.background(
                        brush = PrimaryGradient,
                    )

                    CustomButtonState.SECONDARY -> Modifier.background(
                        brush = SecondaryGradient,
                    )

                    CustomButtonState.DISABLED -> Modifier.background(
                        color = colorScheme.neutralLine,
                    )
                }
            )
            .clickable(
                enabled = state != CustomButtonState.DISABLED && state != CustomButtonState.LOADING,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .padding(start = 32.dp, end = 32.dp, top = 16.dp, bottom = 18.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            when (state) {
                CustomButtonState.LOADING -> {
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp),
                        color = colorScheme.neutralWhite,
                        strokeWidth = 2.dp
                    )
                }

                else -> {
                    Text(
                        text = text,
                        color = when (state) {
                            CustomButtonState.SECONDARY -> colorScheme.brandDark
                            CustomButtonState.DISABLED -> colorScheme.neutralDisabled
                            else -> colorScheme.neutralWhite
                        },
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ButtonPreview() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CustomButton(
            text = "Primary Button",
            state = CustomButtonState.PRIMARY
        )

        CustomButton(
            text = "Secondary Button",
            state = CustomButtonState.SECONDARY
        )

        CustomButton(
            text = "Loading",
            state = CustomButtonState.LOADING
        )

        CustomButton(
            text = "Disabled Button",
            state = CustomButtonState.DISABLED
        )
    }
}