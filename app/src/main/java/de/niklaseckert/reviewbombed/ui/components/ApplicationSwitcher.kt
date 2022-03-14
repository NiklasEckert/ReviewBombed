package de.niklaseckert.reviewbombed.ui.components

import androidx.compose.runtime.Composable
import de.niklaseckert.reviewbombed.feature_login.presentation.AccountState
import de.niklaseckert.reviewbombed.ui.screens.LoginScreen

/**
 * Composable to switch Applications.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Composable
fun ApplicationSwitcher() {
    val vm = AccountState.current
    if (vm.isLoggedIn) {
        ReviewBombedScreenContainer()
    } else {
        LoginScreen()
    }
}