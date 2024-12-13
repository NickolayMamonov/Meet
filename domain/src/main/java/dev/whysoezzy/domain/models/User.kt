package dev.whysoezzy.domain.models

data class User(
    val id: Long,
    val name: String,
    val phoneNum:String,
    val city: String,
    val aboutMyself: String,
    val tags: List<Tag>,
    val job: String,
    val imageUrl: String,
    val social: Social,
    val myEvents: List<Meeting>,
    val myCommunities: List<Community>
)
