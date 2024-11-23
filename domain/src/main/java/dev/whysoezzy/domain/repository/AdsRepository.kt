package dev.whysoezzy.domain.repository

import dev.whysoezzy.domain.models.AdBlock
import kotlinx.coroutines.flow.Flow

interface AdsRepository {
    suspend fun getAds(): Flow<List<AdBlock>>
}