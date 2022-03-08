package de.niklaseckert.reviewbombed.feature_list.presentation

import de.niklaseckert.reviewbombed.core.domain.model.ListExcerpt

data class ListExcerptState(
    val listExcerptItems: List<ListExcerpt> = emptyList(),
    val isLoading: Boolean = false
) {
}