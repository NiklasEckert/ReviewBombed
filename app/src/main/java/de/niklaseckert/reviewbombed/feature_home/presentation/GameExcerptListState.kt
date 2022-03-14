package de.niklaseckert.reviewbombed.feature_home.presentation

import de.niklaseckert.reviewbombed.core.domain.model.GameExcerpt

/**
 * Data class that represents the List Game Excerpt State.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
data class GameExcerptListState(

    /** Contains a list of Game Excerpts which the State refers to. */
    val gameExcerptItems: List<GameExcerpt> = emptyList(),

    /** Expresses if the State is loading or not. */
    val isLoading: Boolean = false
) {
}