package de.niklaseckert.reviewbombed.feature_login.data.service

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import de.niklaseckert.reviewbombed.feature_login.data.local.SaveAccount
import de.niklaseckert.reviewbombed.feature_login.data.remote.LoginApi
import de.niklaseckert.reviewbombed.feature_login.data.remote.dto.UserResponse
import de.niklaseckert.reviewbombed.feature_login.domain.service.LoginService
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import okhttp3.Credentials
import retrofit2.Response

class LoginServiceImpl(
    private val api: LoginApi,
    private val saveAccount: SaveAccount
): LoginService {

    override fun signIn(username: String, password: String): Boolean {
        val credentials = Credentials.basic(username = username, password = password)
        val userResponse: Response<UserResponse>

        runBlocking {
            userResponse = api.signIn(credentials)

            if (userResponse.isSuccessful) {
                saveAccount.setAccountId(userResponse.body()?.toUser()?.id ?: -1)
                saveAccount.setAccountCredentials(credentials = credentials)
            }
        }
        if (!userResponse.isSuccessful) {
            return false
        }
        return true
    }

    override fun automaticSignIn(): Boolean {
        val credentials: String
        val userResponse: Response<UserResponse>

        runBlocking {
            credentials = saveAccount.getAccountCredentials()

            userResponse = api.signIn(credentials)

            if (userResponse.isSuccessful) {
                saveAccount.setAccountId(userResponse.body()?.toUser()?.id ?: -1)
                saveAccount.setAccountCredentials(credentials = credentials)
            }
        }

        if (!userResponse.isSuccessful) {
            return false
        }
        return true
    }

    override fun signOut(): Boolean {
        runBlocking {
            saveAccount.setAccountId(-1)
            saveAccount.setAccountCredentials(credentials = "")
        }
        return true
    }
}