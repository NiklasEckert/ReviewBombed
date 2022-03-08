package de.niklaseckert.reviewbombed.feature_list.data.remote

import de.niklaseckert.reviewbombed.core.data.remote.dto.ListExcerptDto
import de.niklaseckert.reviewbombed.feature_list.data.remote.dto.ListDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ListApi {

    @GET("/lists")
    suspend fun getLists(): List<ListExcerptDto>

    @GET("/lists/{id}")
    suspend fun getList(@Path("id") id: Long): ListDto

}