package dev.whysoezzy.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.whysoezzy.data.local.entity.CommunityEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CommunitiesDao {
    @Query("SELECT * FROM communities")
    fun getAllCommunities(): Flow<List<CommunityEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCommunities(communities: List<CommunityEntity>)

    @Query("UPDATE communities SET isSubscribed = :isSubscribed WHERE id = :communityId")
    suspend fun updateSubscriptionStatus(communityId: String, isSubscribed: Boolean)
}