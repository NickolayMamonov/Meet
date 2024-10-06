package dev.whysoezzy.ui.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.whysoezzy.ui.base.CircleAvatar
import dev.whysoezzy.ui.base.SmallTag
import dev.whysoezzy.ui.base.text.TextSubheading1
import dev.whysoezzy.ui.models.PersonModelUI
import dev.whysoezzy.ui.theme.MeetTheme

@Composable
internal fun PersonCard(
    person: PersonModelUI,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.clickable { onClick() }) {
        Column(modifier = Modifier) {
            CircleAvatar(size = 104.dp, image = person.image)
            TextSubheading1(text = person.name, modifier = Modifier.padding(top = 2.dp))
            SmallTag(text = person.popularTag, color = MeetTheme.colors.neutralSecondaryBackground)
        }
    }

}

@Preview
@Composable
fun PersonCardPreview() {
    PersonCard(
        person = PersonModelUI(
            id = "1",
            name = "Анастасия",
            image = null,
            popularTag = "Дизайн"
        ),
        onClick = {}
    )
}