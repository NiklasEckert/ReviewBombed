package de.niklaseckert.reviewbombed.core.util

import de.niklaseckert.reviewbombed.feature_login.data.local.SaveAccount
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class BasicAuthInterceptor(
    private val saveAccount: SaveAccount
) : Interceptor {

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