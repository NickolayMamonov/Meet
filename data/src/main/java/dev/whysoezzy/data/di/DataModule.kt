package dev.whysoezzy.data.di

import dev.whysoezzy.data.repository.CommunitiesRepositoryImpl
import dev.whysoezzy.data.repository.MeetingsRepositoryImpl
import dev.whysoezzy.data.repository.MoreRepositoryImpl
import dev.whysoezzy.domain.repository.CommunitiesRepository
import dev.whysoezzy.domain.repository.MeetingsRepository
import dev.whysoezzy.domain.repository.MoreRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::MeetingsRepositoryImpl){ bind<MeetingsRepository>() }
    singleOf(::CommunitiesRepositoryImpl){ bind<CommunitiesRepository>() }
    singleOf(::MoreRepositoryImpl){ bind<MoreRepository>() }
}