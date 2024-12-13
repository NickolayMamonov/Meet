package dev.whysoezzy.domain.models

data class AdBlock(
    val id: Long,
    val content: String,
    val imageUrl: String,
    val targetUrl: String
)
