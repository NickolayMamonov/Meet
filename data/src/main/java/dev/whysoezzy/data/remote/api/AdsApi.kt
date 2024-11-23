package dev.whysoezzy.data.remote.api

import dev.whysoezzy.data.remote.dto.AdBlockDto
import retrofit2.http.GET

interface AdsApi {
    @GET("ads")
    suspend fun getAds(): List<AdBlockDto>
}