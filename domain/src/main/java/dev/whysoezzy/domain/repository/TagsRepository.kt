package dev.whysoezzy.domain.repository

import dev.whysoezzy.domain.models.Tag
import kotlinx.coroutines.flow.Flow

interface TagsRepository {
    suspend fun getAllTags(): Flow<List<Tag>>
    suspend fun getPopularTags(): Flow<List<Tag>>
}