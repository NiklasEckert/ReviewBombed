package de.niklaseckert.reviewbombed.feature_home.domain.use_case

import de.niklaseckert.reviewbombed.core.domain.model.GameExcerpt
import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow

/**
 * Use Case to get all currently played Games.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
class GetCurrentlyPlaying(

    /** Repository which contains the items for the Home screen. */
    private val repository: HomeRepository
) {

    /**
     * Method to get all currently played Games from the repository.
     *
     * @return a Flow Resource of a list which contains the Game Excerpts that are currently played.
     */
    operator fun invoke(): Flow<Resource<List<GameExcerpt>>> {
        return repository.getCurrentlyPlaying()
    }
}