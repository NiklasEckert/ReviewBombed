package de.niklaseckert.reviewbombed.feature_home.data.remote

import de.niklaseckert.reviewbombed.core.data.remote.dto.GameExcerptDto
import retrofit2.http.GET

interface HomeApi {

    @GET("/home/currently-playing")
    suspend fun getCurrentlyPlaying(): List<GameExcerptDto>

    @GET("/home/friends-playing")
    suspend fun getFriendsPlaying(): List<GameExcerptDto>

    @GET("/home/friends-finished")
    suspend fun getFriendsFinished(): List<GameExcerptDto>
}