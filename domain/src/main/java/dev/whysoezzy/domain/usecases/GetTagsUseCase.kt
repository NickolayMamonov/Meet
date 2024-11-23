package dev.whysoezzy.domain.usecases

import dev.whysoezzy.domain.models.Tag
import dev.whysoezzy.domain.repository.TagsRepository
import kotlinx.coroutines.flow.Flow

class GetTagsUseCase(
    private val tagsRepository: TagsRepository
) {
    suspend operator fun invoke(): Flow<List<Tag>> =
        tagsRepository.getPopularTags()
}