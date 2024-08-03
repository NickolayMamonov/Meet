package dev.whysoezzy.ui.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.whysoezzy.ui.base.text.TextBody1
import dev.whysoezzy.ui.theme.MeetTheme
import dev.whysoezzy.ui.utils.TabType

@Composable
internal fun TabRow(selectedTabIndex: Int, onTabSelected: (Int) -> Unit, tabs: List<TabType>) {
    TabRow(
        selectedTabIndex = selectedTabIndex,
        contentColor = MeetTheme.colors.brandDefault,
        indicator = { tabPositions ->
            SecondaryIndicator(
                modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                color = MeetTheme.colors.brandDefault
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 8.dp)
    ) {
        tabs.forEachIndexed { index, tab ->
            Tab(
                text = {
                    TextBody1(
                        text = stringResource(id = tab.title),
                        color = when (selectedTabIndex) {
                            index -> MeetTheme.colors.brandDefault
                            else -> MeetTheme.colors.neutralWeak
                        }
                    )
                },
                selected = selectedTabIndex == index,
                onClick = { onTabSelected(index) }
            )
        }
    }
}