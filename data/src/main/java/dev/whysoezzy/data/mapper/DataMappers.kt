package dev.whysoezzy.data.mapper

import dev.whysoezzy.data.local.entity.MeetingEntity
import dev.whysoezzy.data.mapper.DataMappers.toDomain
import dev.whysoezzy.data.remote.dto.AdBlockDto
import dev.whysoezzy.data.remote.dto.CommunityDto
import dev.whysoezzy.data.remote.dto.LocationDto
import dev.whysoezzy.data.remote.dto.MeetingDto
import dev.whysoezzy.data.remote.dto.TagDto
import dev.whysoezzy.data.utils.DateTimeUtils
import dev.whysoezzy.domain.models.AdBlock
import dev.whysoezzy.domain.models.Community
import dev.whysoezzy.domain.models.Location
import dev.whysoezzy.domain.models.Meeting
import dev.whysoezzy.domain.models.Tag
import java.time.LocalDateTime


object DataMappers {
    fun MeetingDto.toDomain() = Meeting(
        id = id,
        title = title,
        description = description,
        dateTime = DateTimeUtils.parseDate(dateTime),
        location = location.toDomain(),
        organizerId = organizerId,
        communityId = communityId,
        tags = tags.map { it.toDomain() },
        participantsCount = participantsCount,
        maxParticipants = maxParticipants,
        imageUrl = imageUrl
    )

    fun LocationDto.toDomain() = Location(
        address = address,
        latitude = latitude,
        longitude = longitude
    )

    fun TagDto.toDomain() = Tag(
        id = id,
        name = name
    )

    fun CommunityDto.toDomain() = Community(
        id = id,
        name = name,
        description = description,
        imageUrl = imageUrl,
        subscribersCount = subscribersCount,
        isSubscribed = isSubscribed
    )

    fun AdBlockDto.toDomain() = AdBlock(
        id = id,
        content = content,
        imageUrl = imageUrl,
        targetUrl = targetUrl
    )

    fun Meeting.toEntity() = MeetingEntity(
        id = id,
        title = title,
        description = description,
        dateTime = DateTimeUtils.formatDate(dateTime),
        locationAddress = location.address,
        locationLatitude = location.latitude,
        locationLongitude = location.longitude,
        organizerId = organizerId,
        communityId = communityId,
        participantsCount = participantsCount,
        maxParticipants = maxParticipants,
        imageUrl = imageUrl
    )

    fun MeetingEntity.toDomain() = Meeting(
        id = id,
        title = title,
        description = description,
        dateTime = DateTimeUtils.parseDate(dateTime),
        location = Location(
            address = locationAddress,
            latitude = locationLatitude,
            longitude = locationLongitude
        ),
        organizerId = organizerId,
        communityId = communityId,
        tags = emptyList(),
        participantsCount = participantsCount,
        maxParticipants = maxParticipants,
        imageUrl = imageUrl
    )
}