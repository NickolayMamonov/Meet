package dev.whysoezzy.data.remote.api

import dev.whysoezzy.data.remote.dto.TagDto
import retrofit2.http.GET

interface TagsApi {
    @GET("tags")
    suspend fun getAllTags(): List<TagDto>

    @GET("tags/popular")
    suspend fun getPopularTags(): List<TagDto>
}