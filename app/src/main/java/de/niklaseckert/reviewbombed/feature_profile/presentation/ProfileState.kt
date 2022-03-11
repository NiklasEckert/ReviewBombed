package de.niklaseckert.reviewbombed.feature_profile.presentation

import de.niklaseckert.reviewbombed.feature_profile.domain.model.Profile

data class ProfileState(
   val profileItem: Profile? = null,
   val isLoading: Boolean = false
) {
}
