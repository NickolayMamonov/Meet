package dev.whysoezzy.domain.utils

sealed class MeetingType {
    object Popular : MeetingType()
    object Featured : MeetingType()
    object All : MeetingType()
}