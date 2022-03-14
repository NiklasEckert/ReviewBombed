package de.niklaseckert.reviewbombed.feature_profile.presentation

import de.niklaseckert.reviewbombed.feature_profile.domain.model.Profile

/**
 * Data class that represents the Profile State.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
data class ProfileState(

   /** Contains a Profile which the Profile State refers to. */
   val profileItem: Profile? = null,

   /** Expresses if the Profile State is loading or not. */
   val isLoading: Boolean = false
) {
}
