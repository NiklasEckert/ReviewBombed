package de.niklaseckert.reviewbombed.feature_home.presentation

import de.niklaseckert.reviewbombed.core.domain.model.GameExcerpt

data class AllCurrentlyPlayingState(
    val gameExcerptItems: List<GameExcerpt> = emptyList(),
    val isLoading: Boolean = false
) {
}