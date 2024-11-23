package dev.whysoezzy.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dev.whysoezzy.data.local.dao.CommunitiesDao
import dev.whysoezzy.data.local.dao.MeetingsDao
import dev.whysoezzy.data.local.dao.TagsDao
import dev.whysoezzy.data.local.entity.CommunityEntity
import dev.whysoezzy.data.local.entity.MeetingEntity
import dev.whysoezzy.data.local.entity.MeetingTagCrossRef
import dev.whysoezzy.data.local.entity.TagEntity
import dev.whysoezzy.data.utils.Converters

@Database(
    entities = [
        MeetingEntity::class,
        CommunityEntity::class,
        TagEntity::class,
        MeetingTagCrossRef::class
    ],
    version = 1
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun meetingsDao(): MeetingsDao
    abstract fun communitiesDao(): CommunitiesDao
    abstract fun tagsDao(): TagsDao
}
