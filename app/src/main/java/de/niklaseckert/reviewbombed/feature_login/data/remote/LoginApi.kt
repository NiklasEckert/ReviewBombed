package de.niklaseckert.reviewbombed.feature_login.data.remote

import de.niklaseckert.reviewbombed.feature_login.data.remote.dto.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface LoginApi {
     @GET("login")
     fun login(@Header("Authorization") authHeader: String): Call<UserResponse>
}