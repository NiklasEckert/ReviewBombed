package de.niklaseckert.reviewbombed.feature_list.presentation

import de.niklaseckert.reviewbombed.feature_list.domain.model.ListModel

/**
 * Data class that represents the List State.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
data class ListState(

    /** Contains a List Model which the List State refers to. */
    val listModelItem: ListModel? = null,

    /** Expresses if the List State is loading or not. */
    val isLoading: Boolean = false
) {
}