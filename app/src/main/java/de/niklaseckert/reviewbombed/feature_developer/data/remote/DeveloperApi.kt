package de.niklaseckert.reviewbombed.feature_developer.data.remote

import de.niklaseckert.reviewbombed.feature_developer.data.remote.dto.DeveloperDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DeveloperApi {

    @GET("/developers/{id}")
    suspend fun getDeveloper(@Path("id") id: Long): DeveloperDto

    @GET("/developers")
    suspend fun getDevelopers(): List<DeveloperDto>
}