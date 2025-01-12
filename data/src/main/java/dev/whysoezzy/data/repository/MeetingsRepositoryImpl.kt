package dev.whysoezzy.data.repository

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import dev.whysoezzy.domain.models.DetailsEventModel
import dev.whysoezzy.domain.models.MeetingEventModel
import dev.whysoezzy.domain.repository.MeetingsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf


internal class MeetingsRepositoryImpl : MeetingsRepository {
    private val avatars = listOf(
        "https://picsum.photos/200/300",
        "https://picsum.photos/200/300",
        "https://picsum.photos/200/300",
        "https://picsum.photos/200/300",
        "https://picsum.photos/200/300",
        "https://picsum.photos/200/300",
        "https://picsum.photos/200/300",
    )

    override fun getAllMeetings(): Flow<List<MeetingEventModel>> = flowOf(
        listOf(
            MeetingEventModel("1", "Developer Meeting", "13.09.2024 — Москва", false),
            MeetingEventModel("2", "Developer Meeting", "13.09.2024 — Москва", true),
            MeetingEventModel("3", "Developer Meeting", "13.09.2024 — Москва", false),
            MeetingEventModel("4", "Developer Meeting", "13.09.2024 — Москва", false),
            MeetingEventModel("5", "Developer Meeting", "13.09.2024 — Москва", true),
            MeetingEventModel("6", "Developer Meeting", "13.09.2024 — Москва", false),
            MeetingEventModel("7", "Developer Meeting", "13.09.2024 — Москва", true),
            MeetingEventModel("8", "Developer Meeting", "13.09.2024 — Москва", false),
            MeetingEventModel("9", "Developer Meeting", "13.09.2024 — Москва", false),
            MeetingEventModel("10", "Developer Meeting", "13.09.2024 — Москва", true),
            MeetingEventModel("11", "Developer Meeting", "13.09.2024 — Москва", false),
        )
    )

    override fun getMeetingEvent(name: String): Flow<DetailsEventModel> = flowOf(
        DetailsEventModel(
            "1",
            "Developer Meeting",
            "13.09.2024 — Москва",
            listOf("Kotlin", "Junior", "Moscow"),
            description = LoremIpsum().values.first(),
            images = avatars,
            isEnded = false
        ),
    )
}