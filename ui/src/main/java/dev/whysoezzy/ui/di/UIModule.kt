package dev.whysoezzy.ui.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import dev.whysoezzy.ui.screens.events.viewmodels.EventsViewModel
import dev.whysoezzy.ui.screens.auth.viewmodels.AddProfileViewModel
import dev.whysoezzy.ui.screens.auth.viewmodels.OtpCodeViewModel
import dev.whysoezzy.ui.screens.auth.viewmodels.PhoneNumViewModel
import dev.whysoezzy.ui.screens.communities.viewmodels.CommunitiesViewModel
import dev.whysoezzy.ui.screens.communities.viewmodels.DetailsCommunityViewModel
import dev.whysoezzy.ui.screens.events.viewmodels.DetailsEventViewModel
import dev.whysoezzy.ui.screens.more.viewmodels.MoreViewModel
import dev.whysoezzy.ui.screens.more.viewmodels.MyEventsViewModel
import dev.whysoezzy.ui.screens.more.viewmodels.ProfileViewModel



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