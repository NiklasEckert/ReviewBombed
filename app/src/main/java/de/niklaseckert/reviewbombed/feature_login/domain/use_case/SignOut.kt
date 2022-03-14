package de.niklaseckert.reviewbombed.feature_login.domain.use_case

import de.niklaseckert.reviewbombed.feature_login.domain.service.LoginService

/**
 * Use Case to sign out.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
class SignOut(

    /** Service which contains the Users. */
    private val service: LoginService
) {

    /**
     * Method to sign out of the app.
     *
     * @return if the sign out was successful.
     */
    operator fun invoke() : Boolean {
        return service.signOut()
    }
}