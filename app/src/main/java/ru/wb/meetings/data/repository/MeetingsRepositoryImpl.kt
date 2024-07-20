package ru.wb.meetings.data.repository

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.wb.meetings.domain.models.DetailsEventModel
import ru.wb.meetings.domain.models.MeetingEventModel
import ru.wb.meetings.domain.repository.MeetingsRepository


class MeetingsRepositoryImpl : MeetingsRepository {
    private val avatars = listOf(
        "https://picsum.photos/200/300",
        "https://picsum.photos/200/300",
        "https://picsum.photos/200/300",
        "https://picsum.photos/200/300",
        "https://picsum.photos/200/300",
        "https://picsum.photos/200/300",
        "https://picsum.photos/200/300",
    )

    override fun getAllMeetings(): Flow<List<MeetingEventModel>> = flow {
        emit(
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
    }

    override fun getMeetingEvent(name:String): Flow<DetailsEventModel> = flow {
        emit(
            DetailsEventModel("1", "Developer Meeting", "13.09.2024 — Москва", listOf("Kotlin","Junior","Moscow"), description = LoremIpsum().values.first(), images = avatars, isEnded = false),
        )
    }
}