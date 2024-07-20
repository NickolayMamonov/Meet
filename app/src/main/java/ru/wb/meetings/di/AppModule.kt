package ru.wb.meetings.di

import org.koin.androidx.viewmodel.dsl.viewModel
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

val appModule = module {
    viewModel {
        EventsViewModel(
            getAllMeetings = get(),
            getActiveMeetings = get()
        )
    }
    viewModel { DetailsEventViewModel(getEvent = get()) }
    viewModel { CommunitiesViewModel(getCommunityUseCase = get()) }
    viewModel { DetailsCommunityViewModel(getCommunityDetailsUseCase = get()) }
    viewModel { MoreViewModel(getUserProfileUseCase = get()) }
    viewModel { ProfileViewModel(getUserProfileUseCase = get()) }
    viewModel {
        MyEventsViewModel(
            getPlannedMeetingsUseCase = get(),
            getPassedMeetingsUseCase = get()
        )
    }
    viewModel { PhoneNumViewModel() }
    viewModel { OtpCodeViewModel() }
    viewModel { AddProfileViewModel() }
}