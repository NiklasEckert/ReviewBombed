package de.niklaseckert.reviewbombed.feature_login.presentation

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import de.niklaseckert.reviewbombed.feature_login.domain.use_case.AutomaticSignIn
import de.niklaseckert.reviewbombed.feature_login.domain.use_case.SignIn
import de.niklaseckert.reviewbombed.feature_login.domain.use_case.SignOut
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

val AccountState = compositionLocalOf<AccountViewModel> { error("User State Context Not Found!") }

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val signIn: SignIn,
    private val automaticSignIn: AutomaticSignIn,
    private val signOut: SignOut
) : ViewModel() {

    var isLoggedIn by mutableStateOf(false)
    var isBusy by mutableStateOf(false)

    init {
        runBlocking {
            automaticSignInFun()
        }
    }

    fun signInFun(username: String, password: String) {
        isBusy = true
        isLoggedIn = signIn(username = username, password = password)
        isBusy = false
    }

    fun automaticSignInFun() {
        isBusy = true
        isLoggedIn = automaticSignIn()
        isBusy = false
    }

    fun signOutFun() {
        isBusy = true
        isLoggedIn = !signOut()
        isBusy = false
    }
}