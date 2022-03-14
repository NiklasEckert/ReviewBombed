package de.niklaseckert.reviewbombed.feature_login.domain.use_case

import de.niklaseckert.reviewbombed.feature_login.domain.service.LoginService

/**
 * Use Case to sign in.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
class SignIn(

    /** Service which contains the Users. */
    private val service: LoginService
) {

    /**
     * Method to sign in the app.
     *
     * @param username contains the username which should be signed in.
     * @param password contains the password which should be signed in.
     * @return if the sign in was successful.
     */
    operator fun invoke(username: String, password: String) : Boolean{
        return service.signIn(username = username, password = password)
    }
}