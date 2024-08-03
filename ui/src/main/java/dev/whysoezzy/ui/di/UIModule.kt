package dev.whysoezzy.ui.di

import dev.whysoezzy.ui.screens.auth.otp.OtpCodeViewModel
import dev.whysoezzy.ui.screens.auth.phone.PhoneNumViewModel
import dev.whysoezzy.ui.screens.auth.profile.AddProfileViewModel
import dev.whysoezzy.ui.screens.communities.detail.DetailsCommunityViewModel
import dev.whysoezzy.ui.screens.communities.primary.CommunitiesViewModel
import dev.whysoezzy.ui.screens.events.detail.DetailsEventViewModel
import dev.whysoezzy.ui.screens.events.primary.EventsViewModel
import dev.whysoezzy.ui.screens.more.myevents.MyEventsViewModel
import dev.whysoezzy.ui.screens.more.primary.MoreViewModel
import dev.whysoezzy.ui.screens.more.profile.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module


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