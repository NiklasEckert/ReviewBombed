package de.niklaseckert.reviewbombed.feature_login.domain.service

import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_login.domain.model.User
import kotlinx.coroutines.flow.Flow

interface LoginService {

    fun login(username: String, password: String): Flow<Resource<User>>
}