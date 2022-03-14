package de.niklaseckert.reviewbombed.feature_home.domain.use_case

import de.niklaseckert.reviewbombed.core.domain.model.GameExcerpt
import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow

/**
 * Use Case to get all Games that friends are currently playing.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
class GetFriendsPlaying(

    /** Repository which contains the items for the Home screen. */
    private val repository: HomeRepository
) {

    /**
     * Method to get all Games that friends are currently playing.
     *
     * @return a Flow Resource of a list which contains the Game Excerpts that friends are currently playing.
     */
    operator fun invoke(): Flow<Resource<List<GameExcerpt>>> {
        return repository.getFriendsPlaying()
    }
}