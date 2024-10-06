package dev.whysoezzy.ui.models

internal data class EventModelUI(
    val id: String,
    val title: String,
    val image: String?,
    val date:String,
    val address:String,
    val tags: List<String>
)

internal data class EventBlockModelUI(
    val id: String,
    val title: String,
    val events: List<EventModelUI>
)

