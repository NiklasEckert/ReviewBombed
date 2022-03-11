package de.niklaseckert.reviewbombed.feature_profile.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import de.niklaseckert.reviewbombed.feature_profile.data.local.entity.ProfileEntity

@Dao
interface ProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProfile(reviews: List<ProfileEntity>)

    @Query("DELETE FROM profileentity WHERE id in (:ids)")
    suspend fun deleteProfiles(ids: List<Long>)

    @Query("SELECT * FROM profileentity WHERE id = :id LIMIT 1")
    suspend fun getProfileById(id: Long): ProfileEntity?

    @Query("SELECT * FROM profileentity WHERE id in (:ids)")
    suspend fun getProfilesById(ids: List<Long>): List<ProfileEntity>
}