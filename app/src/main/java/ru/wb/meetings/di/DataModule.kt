package ru.wb.meetings.di

import org.koin.dsl.module
import ru.wb.meetings.data.repository.CommunitiesRepositoryImpl
import ru.wb.meetings.data.repository.MeetingsRepositoryImpl
import ru.wb.meetings.data.repository.MoreRepositoryImpl
import ru.wb.meetings.domain.repository.CommunitiesRepository
import ru.wb.meetings.domain.repository.MeetingsRepository
import ru.wb.meetings.domain.repository.MoreRepository

val dataModule = module{
    single<MeetingsRepository> { MeetingsRepositoryImpl() }
    single<CommunitiesRepository>{CommunitiesRepositoryImpl()}
    single<MoreRepository>{MoreRepositoryImpl()}
}