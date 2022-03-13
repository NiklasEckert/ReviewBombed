package de.niklaseckert.reviewbombed.feature_game.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import de.niklaseckert.reviewbombed.feature_game.data.local.entity.GameEntity

/**
 * Interface which represents the Data Access Object for Games.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Dao
interface GameDao {

    /**
     * Method to insert a list of Games.
     *
     * @param games contains a list of Games which should be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGames(games: List<GameEntity>)

    /**
     * Method to delete a list of games.
     *
     * @param ids contains a list of ids of the Games that should be deleted.
     */
    @Query("DELETE FROM gameentity WHERE id IN (:ids)")
    suspend fun deleteGames(ids: List<Long>)

    /**
     * Method to get a Game by the id.
     *
     * @param id contains the id of a Game.
     * @return the corresponding Game.
     */
    @Query("SELECT * FROM gameentity WHERE id = :id LIMIT 1")
    suspend fun getGameById(id: Long): GameEntity?
}