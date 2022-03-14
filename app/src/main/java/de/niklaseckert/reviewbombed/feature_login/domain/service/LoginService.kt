package de.niklaseckert.reviewbombed.feature_login.domain.service

/**
 * Interface which the Login Service implements.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
interface LoginService {

    /**
     * Method to sign in with a User.
     *
     * @param username contains the username of the User.
     * @param password contains the password of the User.
     * @return if the login was successful.
     */
    fun signIn(username: String, password: String): Boolean

    /**
     * Method to keep a User signed in.
     *
     * @return if the automatic sign in was successful.
     */
    fun automaticSignIn(): Boolean

    /**
     * Method to sign a User out.
     *
     * @return if the User has been successfully signed out.
     */
    fun signOut(): Boolean
}