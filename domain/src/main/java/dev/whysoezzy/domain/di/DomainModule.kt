package dev.whysoezzy.domain.di

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