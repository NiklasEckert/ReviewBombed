package de.niklaseckert.reviewbombed.feature_home.domain.repository

import de.niklaseckert.reviewbombed.core.domain.model.GameExcerpt
import de.niklaseckert.reviewbombed.core.util.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Interface which the Home Repository implements.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
interface HomeRepository {

    /**
     * Method to get all games that are currently played.
     *
     * @return a Flow Resource of a list which contains the Game Excerpts that are currently played.
     */
    fun getCurrentlyPlaying(): Flow<Resource<List<GameExcerpt>>>

    /**
     * Method to get all Games that friends are currently playing.
     *
     * @return a Flow Resource of a list which contains the Game Excerpts that friends are currently playing.
     */
    fun getFriendsPlaying(): Flow<Resource<List<GameExcerpt>>>

    /**
     * Method to get all Games that friends recently finished.
     *
     * @return a Flow Resource of a list which contains the Game Excerpts that friends recently finished.
     */
    fun getFriendsFinished(): Flow<Resource<List<GameExcerpt>>>
}