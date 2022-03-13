package de.niklaseckert.reviewbombed.feature_profile.data.remote

import de.niklaseckert.reviewbombed.feature_profile.data.remote.dto.ProfileDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProfileApi {

    @GET("users/{id}")
    suspend fun getProfile(@Path("id") id: Long): ProfileDto

    @GET("users/{id}")
    suspend fun getOwnProfile(@Path("id") id: Long): Response<ProfileDto>
}