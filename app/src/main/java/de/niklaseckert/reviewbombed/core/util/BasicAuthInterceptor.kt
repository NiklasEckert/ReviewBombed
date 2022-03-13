package de.niklaseckert.reviewbombed.core.util

import de.niklaseckert.reviewbombed.feature_login.data.local.SaveAccount
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * Class which intercepts http requests.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
class BasicAuthInterceptor(

    /** Represents the currently logged in account */
    private val saveAccount: SaveAccount
) : Interceptor {

    /**
     * Method that intercepts the requests.
     *
     * @param chain contains the request chain.
     * @return the response with an attached authorization header.
     */
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val authenticatedRequest: Request

        runBlocking {
            authenticatedRequest = request.newBuilder()
                .header("Authorization", saveAccount.getAccountCredentials())
                .build()
        }

        return chain.proceed(authenticatedRequest)
    }
}