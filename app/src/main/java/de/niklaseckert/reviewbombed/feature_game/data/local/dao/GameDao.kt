package de.niklaseckert.reviewbombed.feature_game.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import de.niklaseckert.reviewbombed.feature_game.data.local.entity.GameEntity

@Dao
interface GameDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGames(games: List<GameEntity>)

    @Query("DELETE FROM gameentity WHERE id IN (:ids)")
    suspend fun deleteGames(ids: List<Long>)

    @Query("SELECT * FROM gameentity WHERE id = :id LIMIT 1")
    suspend fun getGameById(id: Long): GameEntity
}