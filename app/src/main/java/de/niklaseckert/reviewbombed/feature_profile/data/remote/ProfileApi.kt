package de.niklaseckert.reviewbombed.feature_profile.data.remote

import de.niklaseckert.reviewbombed.feature_profile.data.remote.dto.ProfileDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Interface for the Profile API.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
interface ProfileApi {

    /**
     * Get Mapping for a specific Profile.
     *
     * @param id contains the id of a Game.
     * @return the profile Dto that corresponds to the id.
     */
    @GET("users/{id}")
    suspend fun getProfile(@Path("id") id: Long): ProfileDto

}