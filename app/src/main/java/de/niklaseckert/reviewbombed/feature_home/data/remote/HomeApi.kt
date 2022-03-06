package de.niklaseckert.reviewbombed.feature_home.data.remote

import de.niklaseckert.reviewbombed.core.data.remote.dto.GameExcerptDto
import retrofit2.http.GET

interface HomeApi {

    @GET("/home")
    suspend fun getCurrentlyPlaying(): List<GameExcerptDto>
}