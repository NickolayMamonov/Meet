package ru.wb.meetings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay
import ru.wb.meetings.ui.screens.SplashScreen
import ru.wb.meetings.ui.screens.main.MainScreen
import ru.wb.meetings.ui.theme.MeetTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MeetTheme {
                var showSplashScreen by remember { mutableStateOf(true) }
                LaunchedEffect(key1 = true) {
                    delay(3000)
                    showSplashScreen = false
                }
                when {
                    showSplashScreen -> {
                        SplashScreen()
                    }
                    else -> {
                        MainScreen()
                    }
                }

            }

        }
    }
}



