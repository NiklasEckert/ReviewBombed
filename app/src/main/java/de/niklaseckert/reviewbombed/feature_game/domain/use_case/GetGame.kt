package de.niklaseckert.reviewbombed.feature_game.domain.use_case

import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_game.domain.model.Game
import de.niklaseckert.reviewbombed.feature_game.domain.repository.GameRepository
import kotlinx.coroutines.flow.Flow

/**
 * Use Case to get on specific Game.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
class GetGame(

    /** Repository which contains the Games. */
    private val repository: GameRepository
) {

    /**
     * Method to get one specific Game from the repository.
     *
     * @param id contains the id of a Game.
     * @return a Flow Resource of the Game.
     */
    operator fun invoke(id: Long): Flow<Resource<Game>> {
        return repository.getGame(id)
    }
}