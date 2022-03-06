package de.niklaseckert.reviewbombed.feature_home.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import de.niklaseckert.reviewbombed.core.data.local.entity.GameExcerptEntity

@Dao
interface HomeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrentlyPlaying(gameExcerpts: List<GameExcerptEntity>)

    @Query("DELETE FROM gameexcerptentity")
    suspend fun deleteAllCurrentlyPlaying()

    @Query("SELECT * FROM gameexcerptentity")
    suspend fun getAllCurrentlyPlaying(): List<GameExcerptEntity>
}