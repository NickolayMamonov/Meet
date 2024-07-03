package ru.wb.meetings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ru.wb.meetings.navigation.graphs.RootNavGraph
import ru.wb.meetings.ui.theme.MeetTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MeetTheme {
                RootNavGraph()
            }

        }
    }
}



