package de.niklaseckert.reviewbombed.feature_list.data.remote

import de.niklaseckert.reviewbombed.core.data.remote.dto.ListExcerptDto
import de.niklaseckert.reviewbombed.feature_list.data.remote.dto.ListDto
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Interface for the List API.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
interface ListApi {

    /**
     * Get Mapping for all Lists.
     *
     * @return a list of all List Excerpt Dtos.
     */
    @GET("/lists")
    suspend fun getLists(): List<ListExcerptDto>

    /**
     * Get Mapping for a specific List.
     *
     * @param id contains the id of a List.
     * @return the List Dto that corresponds to the id.
     */
    @GET("/lists/{id}")
    suspend fun getList(@Path("id") id: Long): ListDto

}