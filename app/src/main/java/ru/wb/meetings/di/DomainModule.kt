package ru.wb.meetings.di

import org.koin.dsl.module
import ru.wb.meetings.domain.usecases.GetActiveMeetingsUseCase
import ru.wb.meetings.domain.usecases.GetAllMeetingsUseCase
import ru.wb.meetings.domain.usecases.GetCommunityDetailsUseCase
import ru.wb.meetings.domain.usecases.GetCommunityUseCase
import ru.wb.meetings.domain.usecases.GetEventDetailsUseCase
import ru.wb.meetings.domain.usecases.GetPassedMeetingsUseCase
import ru.wb.meetings.domain.usecases.GetPlannedMeetingsUseCase
import ru.wb.meetings.domain.usecases.GetUserProfileUseCase

val domainModule = module {
    factory<GetAllMeetingsUseCase> { GetAllMeetingsUseCase(get()) }
    factory<GetActiveMeetingsUseCase> { GetActiveMeetingsUseCase(get()) }
    factory<GetEventDetailsUseCase> { GetEventDetailsUseCase(get()) }
    factory<GetCommunityUseCase> { GetCommunityUseCase(get()) }
    factory<GetCommunityDetailsUseCase> { GetCommunityDetailsUseCase(get()) }
    factory<GetUserProfileUseCase> { GetUserProfileUseCase(get()) }
    factory<GetPlannedMeetingsUseCase> { GetPlannedMeetingsUseCase(get()) }
    factory<GetPassedMeetingsUseCase> { GetPassedMeetingsUseCase(get()) }
}