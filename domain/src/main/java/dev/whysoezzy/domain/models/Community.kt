package dev.whysoezzy.domain.models

data class Community(
    val id: Long,
    val name: String,
    val description: String,
    val imageUrl: String,
    val tags: List<Tag>,
    val subscribers: List<User>,
    val events: List<Meeting>,
    val lastEvents: List<Meeting>
)
