package de.niklaseckert.reviewbombed.feature_login.domain.use_case

import de.niklaseckert.reviewbombed.feature_login.domain.service.LoginService

class SignIn(
    private val service: LoginService
) {
    operator fun invoke(username: String, password: String) : Boolean{
        return service.signIn(username = username, password = password)
    }
}