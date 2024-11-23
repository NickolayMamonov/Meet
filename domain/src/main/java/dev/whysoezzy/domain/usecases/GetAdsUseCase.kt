package dev.whysoezzy.domain.usecases

import dev.whysoezzy.domain.models.AdBlock
import dev.whysoezzy.domain.repository.AdsRepository
import kotlinx.coroutines.flow.Flow

class GetAdsUseCase(
    private val adsRepository: AdsRepository
) {
    suspend operator fun invoke(): Flow<List<AdBlock>> =
        adsRepository.getAds()
}