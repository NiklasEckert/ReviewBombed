package de.niklaseckert.reviewbombed.feature_login.domain.use_case

import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_login.domain.model.User
import de.niklaseckert.reviewbombed.feature_login.domain.service.LoginService
import kotlinx.coroutines.flow.Flow

class PostLogin(
    private val service: LoginService
) {

    operator fun invoke(username: String, password: String): Flow<Resource<User>> {
        return service.login(username = username, password = password)
    }
}