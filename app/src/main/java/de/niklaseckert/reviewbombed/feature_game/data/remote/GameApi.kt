package de.niklaseckert.reviewbombed.feature_game.data.remote

import de.niklaseckert.reviewbombed.feature_game.data.remote.dto.GameDto
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Interface for the Game API.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
interface GameApi {

    /**
     * Get Mapping for a specific Game.
     *
     * @param id contains the id of a Game.
     * @return the Game Dto that corresponds to the id.
     */
    @GET("/games/{id}")
    suspend fun getGame(@Path("id") id: Long): GameDto
}