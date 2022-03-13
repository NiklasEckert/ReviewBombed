package de.niklaseckert.reviewbombed.feature_login.domain.use_case

import de.niklaseckert.reviewbombed.feature_login.domain.service.LoginService

class AutomaticSignIn(
    private val service: LoginService
) {

    operator fun invoke() : Boolean {
        return service.automaticSignIn()
    }
}