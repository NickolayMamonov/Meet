package dev.whysoezzy.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider


@Composable
fun MeetTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColorScheme provides MainColorScheme,
        LocalTypography provides MainTypographyTextStyle
    ) {
        MaterialTheme(
            content = content
        )
    }
}

object MeetTheme{
    val colors: ColorScheme
        @Composable get() = LocalColorScheme.current
    val typography: MainTypography
        @Composable get() = LocalTypography.current
}