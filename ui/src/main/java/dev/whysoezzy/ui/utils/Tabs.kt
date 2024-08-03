package dev.whysoezzy.ui.utils

import dev.whysoezzy.ui.R

internal sealed class TabType(val title: Int) {
    class MyEventsTab(title: Int) : TabType(title)
    class EventsTab(title: Int) : TabType(title)
}


enum class MyEventsTabs(val title: Int) {
    PLANNED(R.string.meeting_planned),
    PASSED(R.string.meeting_passed)
}

enum class EventsTabs(val title: Int) {
    ALL_MEETINGS(R.string.all_meetings),
    ACTIVE(R.string.meeting_active)
}