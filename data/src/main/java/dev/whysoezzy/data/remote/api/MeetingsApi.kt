package dev.whysoezzy.data.remote.api

import dev.whysoezzy.data.remote.dto.MeetingDto
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface MeetingsApi {
    @GET("meetings/featured")
    suspend fun getFeaturedMeetings(): List<MeetingDto>

    @GET("meetings")
    suspend fun getUpcomingMeetings(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): List<MeetingDto>

    @GET("meetings/search")
    suspend fun searchMeetings(@Query("query") query: String): List<MeetingDto>

    @GET("meetings/{meetingId}")
    suspend fun getMeetingDetails(
        @Path("meetingId") meetingId: String
    ): MeetingDto

    @GET("meetings/by-tags")
    suspend fun getMeetingsByTags(
        @Query("tags") tags: List<String>,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): List<MeetingDto>

    @POST("meetings/{meetingId}/join")
    suspend fun joinMeeting(@Path("meetingId") meetingId: String): Boolean

    @POST("meetings/{meetingId}/leave")
    suspend fun leaveMeeting(@Path("meetingId") meetingId: String): Boolean
}