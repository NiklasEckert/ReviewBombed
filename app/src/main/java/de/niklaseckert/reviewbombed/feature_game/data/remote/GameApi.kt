package de.niklaseckert.reviewbombed.feature_game.data.remote

import de.niklaseckert.reviewbombed.feature_game.data.remote.dto.GameDto
import retrofit2.http.GET
import retrofit2.http.Path

interface GameApi {

    @GET("/games/{id}")
    suspend fun getGame(@Path("id") id: Long): GameDto
}