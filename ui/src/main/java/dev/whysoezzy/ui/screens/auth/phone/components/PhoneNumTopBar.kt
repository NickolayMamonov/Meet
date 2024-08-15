package dev.whysoezzy.ui.screens.auth.phone.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import dev.whysoezzy.ui.R

@Composable
@OptIn(ExperimentalMaterial3Api::class)
internal fun PhoneNumTopBar(navController: NavController) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = null
                )
            }
        }, title = {}
    )
}