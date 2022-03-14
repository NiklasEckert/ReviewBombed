package de.niklaseckert.reviewbombed.feature_list.presentation

import de.niklaseckert.reviewbombed.core.domain.model.ListExcerpt

/**
 * Data class that represents the List Excerpt State.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
data class ListExcerptState(

    /** Contains a List Excerpt which the List Excerpt State refers to. */
    val listExcerptItems: List<ListExcerpt> = emptyList(),

    /** Expresses if the List Excerpt State is loading or not. */
    val isLoading: Boolean = false
) {
}