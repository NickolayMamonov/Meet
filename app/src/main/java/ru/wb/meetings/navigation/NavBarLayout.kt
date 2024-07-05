package dev.whysoezzy.testwbproject.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import ru.wb.meetings.ui.theme.MainColorScheme
import ru.wb.meetings.ui.theme.MainTypographyTextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(
    items: List<NavigationItem>,
    currentRoute: String?,
    onClick: (NavigationItem) -> Unit,
) {
    NavigationBar(
        containerColor = MainColorScheme.neutralWhite
    ) {
        items.forEachIndexed { index, navigationItem ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                ),
                selected = currentRoute == navigationItem.route,
                onClick = { onClick(navigationItem) },
                icon = {
                    if (currentRoute == navigationItem.route) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = navigationItem.title,
                                    style = MainTypographyTextStyle.bodyText1
                                )
                                Icon(
                                    painter = painterResource(id = navigationItem.selectedIcon),
                                    contentDescription = null,
                                    tint = MainColorScheme.neutralActive
                                )
                            }


                        }
                    } else {
                        Icon(
                            painter = painterResource(id = navigationItem.unSelectedIcon),
                            contentDescription = null,
                            tint = MainColorScheme.neutralActive
                        )
                    }

                }

            )
        }
    }
}