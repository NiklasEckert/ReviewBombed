package de.niklaseckert.reviewbombed.feature_developer.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import de.niklaseckert.reviewbombed.feature_developer.data.local.entity.DeveloperEntity

@Dao
interface DeveloperDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDevelopers(developers: List<DeveloperEntity>)

    @Query("DELETE FROM developerentity WHERE id IN (:ids)")
    suspend fun deleteDevelopers(ids: List<Long>)

    @Query("SELECT * FROM developerentity WHERE id = :id")
    suspend fun getDeveloperById(id: Long): DeveloperEntity

    @Query("SELECT * FROM developerentity WHERE name LIKE '%' || :name || '%'")
    suspend fun getDevelopersByName(name: String): List<DeveloperEntity>

    @Query("SELECT * FROM developerentity")
    suspend fun getAllDevelopers(): List<DeveloperEntity>
}