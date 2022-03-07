package de.niklaseckert.reviewbombed.feature_home.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import de.niklaseckert.reviewbombed.core.data.local.entity.GameExcerptEntity
import de.niklaseckert.reviewbombed.core.data.local.entity.GameExcerptScope

@Dao
interface HomeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGameExcerptList(gameExcerpts: List<GameExcerptEntity>)

    @Query("DELETE FROM gameexcerptentity WHERE scope = :scope")
    suspend fun deleteGameExcerptWithScope(scope: GameExcerptScope)

    @Query("SELECT * FROM gameexcerptentity WHERE scope = :scope")
    suspend fun getGameExcerptListWithScope(scope: GameExcerptScope): List<GameExcerptEntity>

}