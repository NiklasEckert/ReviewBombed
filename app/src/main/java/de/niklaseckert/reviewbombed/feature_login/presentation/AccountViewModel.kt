package de.niklaseckert.reviewbombed.feature_login.presentation

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import de.niklaseckert.reviewbombed.feature_login.data.local.SaveAccount
import de.niklaseckert.reviewbombed.feature_login.domain.use_case.AutomaticSignIn
import de.niklaseckert.reviewbombed.feature_login.domain.use_case.SignIn
import de.niklaseckert.reviewbombed.feature_login.domain.use_case.SignOut
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

/** Represents the Account State. */
val AccountState = compositionLocalOf<AccountViewModel> { error("User State Context Not Found!") }

/**
 * Class which represents the View Model for Accounts.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@HiltViewModel
class AccountViewModel @Inject constructor(

    /** Contains the Sign In Use Case. */
    private val signIn: SignIn,

    /** Contains the Automatic Sign In Use Case. */
    private val automaticSignIn: AutomaticSignIn,

    /** Contains the Sign Out Use Case. */
    private val signOut: SignOut,

    /** Contains the Save Account class */
    val saveAccount: SaveAccount
) : ViewModel() {

    /** Represents if someone is already logged in. */
    var isLoggedIn by mutableStateOf(false)

    /** Represents if the View Model is doing something. */
    var isBusy by mutableStateOf(false)

    init {

        /**
         * Initialize with automatic sign in.
         */
        runBlocking {
            automaticSignInFun()
        }
    }

    /**
     * Method to sign in.
     *
     * @param username contains the username which should be signed in.
     * @param password contains the password which should be signed in.
     */
    fun signInFun(username: String, password: String) {
        isBusy = true
        isLoggedIn = signIn(username = username, password = password)
        isBusy = false
    }

    /**
     * Method to automatically sign in.
     */
    fun automaticSignInFun() {
        isBusy = true
        isLoggedIn = automaticSignIn()
        isBusy = false
    }

    /**
     * Method to sign out.
     */
    fun signOutFun() {
        isBusy = true
        isLoggedIn = !signOut()
        isBusy = false
    }
}