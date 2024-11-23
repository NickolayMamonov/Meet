package dev.whysoezzy.domain.di

import dev.whysoezzy.domain.usecases.GetAdsUseCase
import dev.whysoezzy.domain.usecases.GetCommunitiesUseCase
import dev.whysoezzy.domain.usecases.GetFeaturedMeetingsUseCase
import dev.whysoezzy.domain.usecases.GetMeetingsByTagsUseCase
import dev.whysoezzy.domain.usecases.GetTagsUseCase
import dev.whysoezzy.domain.usecases.GetUpcomingMeetingsUseCase
import dev.whysoezzy.domain.usecases.SearchMeetingsUseCase
import dev.whysoezzy.domain.usecases.SubscribeToCommunityUseCase
import dev.whysoezzy.domain.usecases.UnsubscribeFromCommunityUseCase
import org.koin.dsl.module


val domainModule = module {
    single { GetFeaturedMeetingsUseCase(get()) }
    single { GetUpcomingMeetingsUseCase(get()) }
    single { SearchMeetingsUseCase(get()) }
    single { GetMeetingsByTagsUseCase(get()) }
    single { GetCommunitiesUseCase(get()) }
    single { SubscribeToCommunityUseCase(get()) }
    single { UnsubscribeFromCommunityUseCase(get()) }
    single { GetTagsUseCase(get()) }
    single { GetAdsUseCase(get()) }
}