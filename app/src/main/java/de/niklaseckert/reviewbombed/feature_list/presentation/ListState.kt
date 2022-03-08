package de.niklaseckert.reviewbombed.feature_list.presentation

import de.niklaseckert.reviewbombed.feature_list.domain.model.ListModel

data class ListState(
    val listModelItem: ListModel? = null,
    val isLoading: Boolean = false
) {
}