package dev.whysoezzy.domain.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import dev.whysoezzy.domain.usecases.GetActiveMeetingsUseCase
import dev.whysoezzy.domain.usecases.GetAllMeetingsUseCase
import dev.whysoezzy.domain.usecases.GetCommunityDetailsUseCase
import dev.whysoezzy.domain.usecases.GetCommunityUseCase
import dev.whysoezzy.domain.usecases.GetEventDetailsUseCase
import dev.whysoezzy.domain.usecases.GetPassedMeetingsUseCase
import dev.whysoezzy.domain.usecases.GetPlannedMeetingsUseCase
import dev.whysoezzy.domain.usecases.GetUserProfileUseCase
import org.koin.core.module.dsl.singleOf


val usecasesModule = module {
    singleOf(::GetAllMeetingsUseCase)
    singleOf(::GetActiveMeetingsUseCase)
    singleOf(::GetEventDetailsUseCase)
    singleOf(::GetCommunityUseCase)
    singleOf(::GetCommunityDetailsUseCase)
    singleOf(::GetUserProfileUseCase)
    singleOf(::GetPlannedMeetingsUseCase)
    singleOf(::GetPassedMeetingsUseCase)
}