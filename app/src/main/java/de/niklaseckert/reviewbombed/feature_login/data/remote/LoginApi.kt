package de.niklaseckert.reviewbombed.feature_login.data.remote

import de.niklaseckert.reviewbombed.feature_login.data.remote.dto.UserResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

/**
 * Interface for the Login API.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
interface LoginApi {

     /**
      * Get Mapping for the login.
      *
      * @param authHeader contains the authorization.
      * @return a Response of the User.
      */
     @GET("login")
     suspend fun signIn(@Header("Authorization") authHeader: String): Response<UserResponse>
}