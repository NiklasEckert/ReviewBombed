package de.niklaseckert.reviewbombed.feature_developer.data.remote

import de.niklaseckert.reviewbombed.feature_developer.data.remote.dto.DeveloperDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DeveloperApi {

    companion object {
        const val BASE_URL = "http://192.168.178.95:8080"
    }

    @GET("/developers/{id}")
    suspend fun getDeveloper(@Path("id") id: Long): DeveloperDto

    @GET("/developers")
    suspend fun getDevelopers(): List<DeveloperDto>
}