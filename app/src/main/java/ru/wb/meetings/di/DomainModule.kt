package ru.wb.meetings.di

import org.koin.core.module.dsl.factoryOf
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
    factoryOf(::GetAllMeetingsUseCase)
    factoryOf(::GetActiveMeetingsUseCase)
    factoryOf(::GetEventDetailsUseCase)
    factoryOf(::GetCommunityUseCase)
    factoryOf(::GetCommunityDetailsUseCase)
    factoryOf(::GetUserProfileUseCase)
    factoryOf(::GetPlannedMeetingsUseCase)
    factoryOf(::GetPassedMeetingsUseCase)
}