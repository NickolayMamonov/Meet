package ru.wb.meetings.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.wb.meetings.R

//val SFProDisplay = FontFamily(
//    Font(R.font.sf_pro_display_regular, FontWeight.Normal),
//    Font(R.font.sf_pro_display_semibold, FontWeight.SemiBold),
//    Font(R.font.sf_pro_display_bold, FontWeight.Bold),
//)
//
//val Typography = Typography(
//    headlineLarge = TextStyle(
//        fontFamily = SFProDisplay,
//        fontWeight = FontWeight.Bold,
//        fontSize = 32.sp,
//        letterSpacing = 0.sp
//    ),
//    headlineMedium = TextStyle(
//        fontFamily = SFProDisplay,
//        fontWeight = FontWeight.Bold,
//        fontSize = 24.sp,
//        letterSpacing = 0.sp
//    ),
//    titleLarge = TextStyle(
//        fontFamily = SFProDisplay,
//        fontWeight = FontWeight.SemiBold,
//        fontSize = 18.sp,
//        lineHeight = 30.sp,
//        letterSpacing = 0.sp
//    ),
//    titleMedium = TextStyle(
//        fontFamily = SFProDisplay,
//        fontWeight = FontWeight.SemiBold,
//        fontSize = 16.sp,
//        lineHeight = 28.sp,
//        letterSpacing = 0.sp
//    ),
//    bodyLarge = TextStyle(
//        fontFamily = SFProDisplay,
//        fontWeight = FontWeight.SemiBold,
//        fontSize = 14.sp,
//        lineHeight = 24.sp,
//        letterSpacing = 0.sp
//    ),
//    bodyMedium = TextStyle(
//        fontFamily = SFProDisplay,
//        fontWeight = FontWeight.Normal,
//        fontSize = 14.sp,
//        lineHeight = 24.sp,
//        letterSpacing = 0.sp
//    ),
//    labelLarge = TextStyle(
//        fontFamily = SFProDisplay,
//        fontWeight = FontWeight.Normal,
//        fontSize = 12.sp,
//        lineHeight = 20.sp,
//        letterSpacing = 0.sp
//    ),
//    labelMedium = TextStyle(
//        fontFamily = SFProDisplay,
//        fontWeight = FontWeight.Normal,
//        fontSize = 10.sp,
//        lineHeight = 16.sp,
//        letterSpacing = 0.sp
//    ),
//    labelSmall = TextStyle(
//        fontFamily = SFProDisplay,
//        fontWeight = FontWeight.SemiBold,
//        fontSize = 10.sp,
//        lineHeight = 16.sp,
//        letterSpacing = 0.sp
//    ),
//)

@Immutable
data class MainTypography(
    val heading1: TextStyle,
    val heading2: TextStyle,
    val subheading1: TextStyle,
    val subheading2: TextStyle,
    val bodyText1: TextStyle,
    val bodyText2: TextStyle,
    val metadata1: TextStyle,
    val metadata2: TextStyle,
    val metadata3: TextStyle,
)

val SFProDisplayFontFamily = FontFamily(
    Font(R.font.sf_pro_display_black,FontWeight.Black),
    Font(R.font.sf_pro_display_bold, FontWeight.Bold),
    Font(R.font.sf_pro_display_heavyitalic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.sf_pro_display_lightitalic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.sf_pro_display_medium, FontWeight.Medium),
    Font(R.font.sf_pro_display_regular, FontWeight.Normal),
    Font(R.font.sf_pro_display_semibolditalic, FontWeight.SemiBold, FontStyle.Italic),
    Font(R.font.sf_pro_display_ultralightitalic, FontWeight.ExtraLight, FontStyle.Italic),
    Font(R.font.sf_pro_display_thinitalic, FontWeight.Thin, FontStyle.Italic),
)

val MainTypographyTextStyle = MainTypography(
    heading1 = TextStyle(
        fontFamily = SFProDisplayFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 38.sp,
        letterSpacing = 0.sp
    ),
    heading2 = TextStyle(
        fontFamily = SFProDisplayFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    subheading1 = TextStyle(
        fontFamily = SFProDisplayFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        lineHeight = 30.sp,
        letterSpacing = 0.sp
    ),
    subheading2 = TextStyle(
        fontFamily = SFProDisplayFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    bodyText1 = TextStyle(
        fontFamily = SFProDisplayFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    bodyText2 = TextStyle(
        fontFamily = SFProDisplayFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    metadata1 = TextStyle(
        fontFamily = SFProDisplayFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    ),
    metadata2 = TextStyle(
        fontFamily = SFProDisplayFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    ),
    metadata3 = TextStyle(
        fontFamily = SFProDisplayFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 10.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    )
)

val LocalTypography = staticCompositionLocalOf {
    MainTypographyTextStyle
}