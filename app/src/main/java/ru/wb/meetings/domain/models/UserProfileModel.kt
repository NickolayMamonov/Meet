package ru.wb.meetings.domain.models

data class UserProfileModel(
    val id : String,
    val name: String,
    val phoneNumber: String,
    val social: List<String>
)