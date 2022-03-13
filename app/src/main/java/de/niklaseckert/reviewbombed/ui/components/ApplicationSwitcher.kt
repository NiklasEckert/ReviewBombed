package de.niklaseckert.reviewbombed.ui.components

import androidx.compose.runtime.Composable
import de.niklaseckert.reviewbombed.feature_login.presentation.AccountState
import de.niklaseckert.reviewbombed.ui.components.ReviewBombedNavigation
import de.niklaseckert.reviewbombed.ui.screens.LoginScreen

@Composable
fun ApplicationSwitcher() {
    val vm = AccountState.current
    if (vm.isLoggedIn) {
        ReviewBombedNavigation()
    } else {
        LoginScreen()
    }
}