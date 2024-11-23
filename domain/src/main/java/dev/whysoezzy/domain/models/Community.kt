package dev.whysoezzy.domain.models

data class Community(
    val id: String,
    val name: String,
    val description: String,
    val imageUrl: String,
    val subscribersCount: Int,
    val isSubscribed: Boolean
)
