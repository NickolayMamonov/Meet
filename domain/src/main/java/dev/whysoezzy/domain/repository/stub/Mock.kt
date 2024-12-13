package dev.whysoezzy.domain.repository.stub

import dev.whysoezzy.domain.models.Community
import dev.whysoezzy.domain.models.Location
import dev.whysoezzy.domain.models.Meeting
import dev.whysoezzy.domain.models.Social
import dev.whysoezzy.domain.models.Tag
import dev.whysoezzy.domain.models.User
import java.util.Date

class Mock {
    fun getListOfEvents(): List<Meeting> = listOf(mockMeeting,mockMeeting)


    val tags = listOf(
        Tag("1", "Спорт"),
        Tag("2", "Отдых"),
        Tag("3", "Нетворкинг")
    )
    val location = Location(
        address = "ул. Пушкина, д. 10",
        latitude = 55.7558,
        longitude = 37.6173
    )

    val mockUser1 = User(
        id = 1L,
        name = "Александр Петров",
        phoneNum = "+7(999)123-45-67",
        city = "Москва",
        aboutMyself = "Люблю активный отдых и новые знакомства",
        tags = tags.subList(0, 2),
        job = "Software Engineer",
        imageUrl = "https://example.com/users/1.jpg",
        social = Social("https://t.me/alex_petrov", "https://vk.com/alex_petrov"),
        myEvents = emptyList(), // Будет заполнено позже
        myCommunities = emptyList() // Будет заполнено позже
    )

    val mockUser2 = User(
        id = 2L,
        name = "Мария Иванова",
        phoneNum = "+7(999)765-43-21",
        city = "Москва",
        aboutMyself = "Организатор мероприятий с 5-летним опытом",
        tags = tags.subList(1, 3),
        job = "Event Manager",
        imageUrl = "https://example.com/users/2.jpg",
        social = Social("https://t.me/maria_ivanova", "https://vk.com/maria_ivanova"),
        myEvents = emptyList(),
        myCommunities = emptyList()
    )

    val mockCommunity = Community(
        id = 1L,
        name = "Активный отдых в Москве",
        description = "Сообщество для любителей активного отдыха и спорта",
        imageUrl = "https://example.com/communities/1.jpg",
        tags = tags,
        subscribers = listOf(mockUser1, mockUser2),
        events = emptyList(), // Будет заполнено позже
        lastEvents = emptyList() // Будет заполнено позже
    )

    val mockMeeting = Meeting(
        id = 1L,
        title = "Велопрогулка по парку",
        description = "Приглашаем всех желающих на велопрогулку по Сокольникам! " +
                "Маршрут подходит для начинающих. Продолжительность - 2 часа.",
        date = Date(), // Текущая дата
        location = location,
        tags = tags,
        host = mockUser1,
        community = mockCommunity,
        maxParticipants = 15,
        participants = listOf(mockUser1, mockUser2),
        imageUrl = "https://example.com/meetings/1.jpg"
    )
}