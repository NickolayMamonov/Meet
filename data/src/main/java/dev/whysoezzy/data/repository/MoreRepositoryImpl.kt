package dev.whysoezzy.data.repository

import dev.whysoezzy.domain.models.MeetingEventModel
import dev.whysoezzy.domain.models.UserProfileModel
import dev.whysoezzy.domain.repository.MoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class MoreRepositoryImpl : MoreRepository {
    override fun getUserProfile(): Flow<UserProfileModel> =
        flowOf(UserProfileModel("1", "Ivan Ivanov", "+7 999 999-99-99", listOf()))

    override fun getMeetings(): Flow<List<MeetingEventModel>> = flowOf(
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