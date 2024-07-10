package ru.wb.meetings.ui.models

data class CommunityEventModel(
    val id: String,
    val title: String,
    val quantity: Int,
    val avatar: String = "https://picsum.photos/200/300",
)