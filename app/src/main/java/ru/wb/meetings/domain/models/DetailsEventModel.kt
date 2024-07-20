package ru.wb.meetings.domain.models

data class DetailsEventModel(
    val id: String,
    val title: String,
    val location: String,
    val tags: List<String>,
    val map: String = "https://cdn.pixabay.com/photo/2016/03/27/16/24/holidays-1283014_1280.jpg",
    val description: String,
    val images: List<String>,
    val isEnded: Boolean = false,
    )