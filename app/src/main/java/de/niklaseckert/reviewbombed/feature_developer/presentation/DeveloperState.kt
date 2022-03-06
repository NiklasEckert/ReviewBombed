package de.niklaseckert.reviewbombed.feature_developer.presentation

import de.niklaseckert.reviewbombed.feature_developer.domain.model.Developer

data class DeveloperState(
    val developerItems: List<Developer> = emptyList(),
    val isLoading: Boolean = false
) {
}