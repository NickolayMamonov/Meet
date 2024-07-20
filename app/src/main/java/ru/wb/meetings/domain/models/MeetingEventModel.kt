package ru.wb.meetings.domain.models

data class MeetingEventModel(
    val id: String,
    val title: String,
    val subTitle: String,
    val isEnded: Boolean,
    val icon: String = "https://picsum.photos/200/300"
)