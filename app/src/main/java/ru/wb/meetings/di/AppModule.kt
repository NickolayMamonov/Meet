package ru.wb.meetings.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import ru.wb.meetings.ui.screens.auth.viewmodels.AddProfileViewModel
import ru.wb.meetings.ui.screens.auth.viewmodels.OtpCodeViewModel
import ru.wb.meetings.ui.screens.auth.viewmodels.PhoneNumViewModel
import ru.wb.meetings.ui.screens.communities.viewmodels.CommunitiesViewModel
import ru.wb.meetings.ui.screens.communities.viewmodels.DetailsCommunityViewModel
import ru.wb.meetings.ui.screens.events.viewmodels.DetailsEventViewModel
import ru.wb.meetings.ui.screens.events.viewmodels.EventsViewModel
import ru.wb.meetings.ui.screens.more.viewmodels.MoreViewModel
import ru.wb.meetings.ui.screens.more.viewmodels.MyEventsViewModel
import ru.wb.meetings.ui.screens.more.viewmodels.ProfileViewModel



val viewModelModule = module {
    viewModelOf(::EventsViewModel)
    viewModelOf(::DetailsEventViewModel)
    viewModelOf(::CommunitiesViewModel)
    viewModelOf(::DetailsCommunityViewModel)
    viewModelOf(::MoreViewModel)
    viewModelOf(::ProfileViewModel)
    viewModelOf(::MyEventsViewModel)
    viewModelOf(::PhoneNumViewModel)
    viewModelOf(::OtpCodeViewModel)
    viewModelOf(::AddProfileViewModel)
}