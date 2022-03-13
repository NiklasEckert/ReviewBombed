package de.niklaseckert.reviewbombed.feature_login.domain.service

interface LoginService {
    fun signIn(username: String, password: String): Boolean
    fun automaticSignIn(): Boolean
    fun signOut(): Boolean
}