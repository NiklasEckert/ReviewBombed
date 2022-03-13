package de.niklaseckert.reviewbombed.core.data.remote.dto

import de.niklaseckert.reviewbombed.core.domain.model.DeveloperExcerpt

/**
 * Data class which represents the data transfer object for a Developer Excerpt.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
data class DeveloperExcerptDto(

    /** Represents the id of a Developer. */
    val id: Long,

    /** Represents the name of a Developer. */
    val name: String
) {

    /**
     * Method that converts a Developer Excerpt Dto into a Developer Excerpt.
     *
     * @return the resulting Developer Excerpt.
     */
    fun toDeveloperExcerpt(): DeveloperExcerpt {
        return DeveloperExcerpt(
            id = id,
            name = name
        )
    }
}