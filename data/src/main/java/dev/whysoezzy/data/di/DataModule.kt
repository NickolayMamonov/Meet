package dev.whysoezzy.data.di

import androidx.room.Room
import dev.whysoezzy.data.local.db.AppDatabase
import dev.whysoezzy.data.remote.api.AdsApi
import dev.whysoezzy.data.remote.api.CommunitiesApi
import dev.whysoezzy.data.remote.api.MeetingsApi
import dev.whysoezzy.data.remote.api.TagsApi
import dev.whysoezzy.data.repository.MeetingsRepositoryImpl
import dev.whysoezzy.domain.repository.AdsRepository
import dev.whysoezzy.domain.repository.CommunitiesRepository
import dev.whysoezzy.domain.repository.MeetingsRepository
import dev.whysoezzy.domain.repository.TagsRepository
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val dataModule = module {
    single { Room.databaseBuilder(get(), AppDatabase::class.java, "app_database").build() }
    single { get<AppDatabase>().meetingsDao() }
    single { get<AppDatabase>().communitiesDao() }
    single { get<AppDatabase>().tagsDao() }

    single<OkHttpClient> {
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
//            .baseUrl(BuildConfig.API_BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(MeetingsApi::class.java) }
    single { get<Retrofit>().create(CommunitiesApi::class.java) }
    single { get<Retrofit>().create(TagsApi::class.java) }
    single { get<Retrofit>().create(AdsApi::class.java) }

    single<MeetingsRepository> { MeetingsRepositoryImpl(get(), get()) }
//    single<CommunitiesRepository> { CommunitiesRepositoryImpl(get(), get()) }
//    single<TagsRepository> { TagsRepositoryImpl(get(), get()) }
//    single<AdsRepository> { AdsRepositoryImpl(get()) }
}