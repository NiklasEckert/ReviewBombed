package de.niklaseckert.reviewbombed.feature_list.data.remote.dto

import de.niklaseckert.reviewbombed.core.data.remote.dto.GameExcerptDto
import de.niklaseckert.reviewbombed.feature_list.data.local.entity.ListEntity

/**
 * Data class which represents the data transfer object for a List.
 */
data class ListDto(

    /** Represents the id of a List. */
    val id: Long,

    /** Represents the name of a List. */
    val name: String,

    /** Represents the description of a List. */
    val description: String,

    /** Represents the Games that are in the List. */
    val games: List<GameExcerptDto>? = emptyList()
) {

    /**
     * Method that converts a List Dto into a List Entity.
     *
     * @return the resulting List Entity.
     */
    fun toListEntity(): ListEntity {
        return ListEntity(
            id = id,
            name = name,
            description = description,
            games = games?.map { it.toGameExcerpt() } ?: emptyList()
        )
    }
}