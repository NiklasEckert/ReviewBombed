package de.niklaseckert.reviewbombed.feature_login.domain.use_case

import de.niklaseckert.reviewbombed.feature_login.domain.service.LoginService

/**
 * Use Case for automatic sign in.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
class AutomaticSignIn(

    /** Service which contains the Users. */
    private val service: LoginService
) {

    /**
     * Method to sign automatically into the app.
     *
     * @return if the sign in was successful.
     */
    operator fun invoke() : Boolean {
        return service.automaticSignIn()
    }
}