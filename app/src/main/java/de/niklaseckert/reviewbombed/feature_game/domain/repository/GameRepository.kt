package de.niklaseckert.reviewbombed.feature_game.domain.repository

import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_game.domain.model.Game
import kotlinx.coroutines.flow.Flow

/**
 * Interface which the Game Repository implements.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
interface GameRepository {

    /**
     * Method to get a specific Game.
     *
     * @param id contains the id of a Game.
     * @return a Flow Resource of the Game.
     */
    fun getGame(id: Long): Flow<Resource<Game>>
}