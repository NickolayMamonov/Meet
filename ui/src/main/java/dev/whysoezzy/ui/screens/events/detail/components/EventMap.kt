package dev.whysoezzy.ui.screens.events.detail.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil.compose.AsyncImage
import dev.whysoezzy.ui.base.MainNetworkIcon

@Composable
fun EventMap(map: String, showImageDialog: Boolean, setShowImageDialog: (Boolean) -> Unit) {
    Box(modifier = Modifier.fillMaxWidth()) {
        MainNetworkIcon(
            image = map,
            isClickable = true,
            showClip = true,
            sizeIcon = 320.dp,
            clipPercent = 16,
            onClick = { setShowImageDialog(true) },
            modifier = Modifier.align(Alignment.Center)
        )
    }
    if (showImageDialog) {
        Dialog(onDismissRequest = { setShowImageDialog(false) }) {
            Box(modifier = Modifier.fillMaxSize()) {
                AsyncImage(
                    model = map,
                    contentDescription = "Full Image",
                    modifier = Modifier
                        .fillMaxSize()
                        .scale(1.5f),
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}