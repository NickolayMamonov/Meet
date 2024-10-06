package dev.whysoezzy.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Immutable
data class ColorScheme(
    val brandDark: Color,// use for pressed
    val brandDefault: Color, // use for button
    val brandDarkMode: Color, // use for Dark Mode
    val brandLight: Color, // variant
    val brandBackground: Color, // use for background
    val neutralActive: Color, // use for font
    val neutralDark: Color, // use for dark mode
    val neutralBody: Color, // use for text
    val neutralWeak: Color, // use for secondary text
    val neutralDisabled: Color, // use for disabled
    val neutralLine: Color, // use for divider
    val neutralSecondaryBackground: Color, // use for background
    val neutralWhite: Color,// use for background
    val accentDanger: Color, // use for errors
    val accentWarning: Color, // use for warning
    val accentSuccess: Color, // use for success
    val accentSafe: Color // variant
)

val MainColorScheme = ColorScheme(
    brandDark = Color(0xFF660EC8),
    brandDefault = Color(0xFF9A41FE),
    brandDarkMode = Color(0xFF8207E8),
    brandLight = Color(0xFFECDAFF),
    brandBackground = Color(0xFFF5ECFF),
    neutralActive = Color(0xFF29183B),
    neutralDark = Color(0xFF190E26),
    neutralBody = Color(0xFF1D0835),
    neutralWeak = Color(0xFFA4A4A4),
    neutralDisabled = Color(0xFFADB5BD),
    neutralLine = Color(0xFFEDEDED),
    neutralSecondaryBackground = Color(0xFFF7F7FC),
    neutralWhite = Color(0xFFFFFFFF),
    accentDanger = Color(0xFFE94242),
    accentWarning = Color(0xFFFDCF41),
    accentSuccess = Color(0xFF2CC069),
    accentSafe = Color(0xFF7BCBCF)
)


private val PrimaryGradientColors = listOf(
    Color(0xFFED3CCA), Color(0xFFDF34D2), Color(0xFFD02BD9), Color(0xFFBF22E1),
    Color(0xFFAE1AE8), Color(0xFF9A10F0), Color(0xFF8306F7), Color(0xFF6600FF)
)
private val SecondaryGradientColors = listOf(
    Color(0xFFFEF1FB), Color(0xFFFDF1FC), Color(0xFFFCF0FC), Color(0xFFFBF0FD),
    Color(0xFFF9EFFD), Color(0xFFF8EEFE), Color(0xFFF6EEFE), Color(0xFFF4EDFF)
)

val PrimaryGradient = Brush.linearGradient(colors = PrimaryGradientColors)
val SecondaryGradient = Brush.linearGradient(colors = SecondaryGradientColors)

val LocalColorScheme = staticCompositionLocalOf {
    MainColorScheme
}