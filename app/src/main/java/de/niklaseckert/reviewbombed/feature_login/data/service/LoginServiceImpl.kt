package de.niklaseckert.reviewbombed.feature_login.data.service

import de.niklaseckert.reviewbombed.feature_login.data.local.SaveAccount
import de.niklaseckert.reviewbombed.feature_login.data.remote.LoginApi
import de.niklaseckert.reviewbombed.feature_login.data.remote.dto.UserResponse
import de.niklaseckert.reviewbombed.feature_login.domain.service.LoginService
import kotlinx.coroutines.runBlocking
import okhttp3.Credentials
import retrofit2.Response

/**
 * Repository which contains the Users.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
class LoginServiceImpl(

    /** API for the Login. */
    private val api: LoginApi,

    /** To log a new account in and an old account out. */
    private val saveAccount: SaveAccount
): LoginService {

    /**
     * Method to sign in with a User.
     *
     * @param username contains the username of the User.
     * @param password contains the password of the User.
     * @return if the login was successful.
     */
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

    /**
     * Method to keep a User signed in.
     *
     * @return if the automatic sign in was successful.
     */
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

    /**
     * Method to sign a User out.
     *
     * @return if the User has been successfully signed out.
     */
    override fun signOut(): Boolean {
        runBlocking {
            saveAccount.setAccountId(-1)
            saveAccount.setAccountCredentials(credentials = "")
        }
        return true
    }
}