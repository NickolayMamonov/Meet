package dev.whysoezzy.domain.models

data class AdBlock(
    val id: String,
    val content: String,
    val imageUrl: String,
    val targetUrl: String
)
