package de.niklaseckert.reviewbombed.feature_list.domain.model

import de.niklaseckert.reviewbombed.core.domain.model.GameExcerpt

class ListModel(
    val id: Long,
    val name: String,
    val description: String,
    val games: List<GameExcerpt>
) {
}