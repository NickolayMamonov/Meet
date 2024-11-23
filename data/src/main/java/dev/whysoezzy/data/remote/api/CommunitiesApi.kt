package dev.whysoezzy.data.remote.api

import dev.whysoezzy.data.remote.dto.CommunityDto
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface CommunitiesApi {
    @GET("communities")
    suspend fun getAllCommunities(): List<CommunityDto>

    @GET("communities/featured")
    suspend fun getFeaturedCommunities(): List<CommunityDto>

    @POST("communities/{communityId}/subscribe")
    suspend fun subscribeToCommunity(@Path("communityId") communityId: String): Boolean

    @POST("communities/{communityId}/unsubscribe")
    suspend fun unsubscribeFromCommunity(@Path("communityId") communityId: String): Boolean
}