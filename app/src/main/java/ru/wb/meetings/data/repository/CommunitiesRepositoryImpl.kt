package ru.wb.meetings.data.repository

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.wb.meetings.domain.models.CommunityDetailModel
import ru.wb.meetings.domain.models.CommunityEventModel
import ru.wb.meetings.domain.models.MeetingEventModel
import ru.wb.meetings.domain.repository.CommunitiesRepository

class CommunitiesRepositoryImpl : CommunitiesRepository {
    override fun getCommunities(): Flow<List<CommunityEventModel>> = flow {
        emit(
            listOf(
                CommunityEventModel("1", "Спорт", 100),
                CommunityEventModel("2", "Музыка", 200),
                CommunityEventModel("3", "Танцы", 300),
                CommunityEventModel("4", "Искусство", 400),
                CommunityEventModel("5", "Кино", 500),
                CommunityEventModel("6", "Кино", 500),
                CommunityEventModel("7", "Кино", 500),
                CommunityEventModel("8", "Кино", 500),
                CommunityEventModel("9", "Кино", 500),
                CommunityEventModel("10", "Кино", 500),
            )
        )
    }



    override fun getCommunity(name: String): Flow<CommunityDetailModel> = flow {
        emit(
            CommunityDetailModel(
                id = "1",
                name = name,
                description = LoremIpsum().values.first(),
                events = listOf(
                    MeetingEventModel("1", "Event Name 1", "Event Description 1", true),
                    MeetingEventModel("2", "Event Name 2", "Event Description 2", false),
                    MeetingEventModel("1", "Event Name 1", "Event Description 1", true),
                    MeetingEventModel("2", "Event Name 2", "Event Description 2", false),
                    MeetingEventModel("1", "Event Name 1", "Event Description 1", true),
                    MeetingEventModel("2", "Event Name 2", "Event Description 2", false),
                    MeetingEventModel("1", "Event Name 1", "Event Description 1", true),
                    MeetingEventModel("2", "Event Name 2", "Event Description 2", false)
                )
            )
        )
    }
}