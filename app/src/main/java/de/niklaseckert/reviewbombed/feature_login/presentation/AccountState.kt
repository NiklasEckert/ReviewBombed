package de.niklaseckert.reviewbombed.feature_login.presentation

import de.niklaseckert.reviewbombed.feature_login.domain.model.User

data class AccountState(
   val userItem: User? = null,
   val isLoading: Boolean = false
) {
}
