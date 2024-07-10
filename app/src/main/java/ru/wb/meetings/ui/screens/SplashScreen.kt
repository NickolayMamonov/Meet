package ru.wb.meetings.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants.IterateForever
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import ru.wb.meetings.R
import ru.wb.meetings.ui.theme.MainColorScheme

@Composable
fun SplashScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(MainColorScheme.brandBackground)
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.base_anim))
        val logoAnimationState =
            animateLottieCompositionAsState(composition = composition, iterations = IterateForever)
        LottieAnimation(
            composition = composition,
            progress = { logoAnimationState.progress }
        )
    }
}