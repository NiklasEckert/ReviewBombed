package de.niklaseckert.reviewbombed.feature_list.data.remote.dto

import de.niklaseckert.reviewbombed.core.data.remote.dto.GameExcerptDto
import de.niklaseckert.reviewbombed.feature_list.data.local.entity.ListEntity

data class ListDto(
    val id: Long,
    val name: String,
    val description: String,
    val games: List<GameExcerptDto>? = emptyList()
) {
    fun toListEntity(): ListEntity {
        return ListEntity(
            id = id,
            name = name,
            description = description,
            games = games?.map { it.toGameExcerpt() } ?: emptyList()
        )
    }
}