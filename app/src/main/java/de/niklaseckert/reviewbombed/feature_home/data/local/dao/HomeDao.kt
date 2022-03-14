package de.niklaseckert.reviewbombed.feature_home.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import de.niklaseckert.reviewbombed.core.data.local.entity.GameExcerptEntity
import de.niklaseckert.reviewbombed.core.data.local.entity.GameExcerptScope

/**
 * Interface which represents the Data Access Object for Games.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Dao
interface HomeDao {

    /**
     * Method to inser a list of Game Excerpt Entities.
     *
     * @param gameExcerpts contains a list of Game Excerpt Entities which should be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGameExcerptList(gameExcerpts: List<GameExcerptEntity>)

    /**
     * Method to delete all Game Excerpts in a certain scope.
     *
     * @param scope contains the scope of all Games that should be deleted.
     */
    @Query("DELETE FROM gameexcerptentity WHERE scope = :scope")
    suspend fun deleteGameExcerptWithScope(scope: GameExcerptScope)

    /**
     * Method to get all Game Excerpts from a certain scope.
     *
     * @param scope contains the scope of the Game Excerpts you want to get.
     * @return a list of Game Excerpt Entities with a certain scope.
     */
    @Query("SELECT * FROM gameexcerptentity WHERE scope = :scope")
    suspend fun getGameExcerptListWithScope(scope: GameExcerptScope): List<GameExcerptEntity>

}