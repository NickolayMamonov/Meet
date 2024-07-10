package ru.wb.meetings.ui.models

data class MeetingEventModel(
    val id: String,
    val title: String,
    val subTitle: String,
    val isEnded: Boolean,
    val icon: String = "https://picsum.photos/200/300"
)