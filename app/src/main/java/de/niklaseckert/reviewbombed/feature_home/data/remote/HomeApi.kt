package de.niklaseckert.reviewbombed.feature_home.data.remote

import de.niklaseckert.reviewbombed.core.data.remote.dto.GameExcerptDto
import retrofit2.http.GET

/**
 * Interface for the Home API.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
interface HomeApi {

    /**
     * Get Mapping for all Games that are currently played.
     *
     * @return a list of Game Excerpts that are currently played.
     */
    @GET("/home/currently-playing")
    suspend fun getCurrentlyPlaying(): List<GameExcerptDto>

    /**
     * Get Mapping for all Games that friends are currently playing.
     *
     * @return a list of Game Excerpts that friends are currently playing.
     */
    @GET("/home/friends-playing")
    suspend fun getFriendsPlaying(): List<GameExcerptDto>

    /**
     * Get Mapping for all Games that friends recently finished.
     *
     * @return a list of Game Excerpts that friends finished playing.
     */
    @GET("/home/friends-finished")
    suspend fun getFriendsFinished(): List<GameExcerptDto>
}