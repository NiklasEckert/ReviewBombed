package de.niklaseckert.reviewbombed.core.data.remote.dto

import de.niklaseckert.reviewbombed.core.domain.model.PublisherExcerpt

/**
 * Data class which represents the data transfer object for a Publisher Excerpt.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
data class PublisherExcerptDto(

    /** Represents the id of a Publisher. */
    val id: Long,

    /** Represents the name of a Publisher. */
    val name: String
) {

    /**
     * Method that converts a Publisher Excerpt Dto into a Publisher Excerpt.
     *
     * @return the resulting Publisher Excerpt.
     */
    fun toPublisherExcerpt(): PublisherExcerpt {
        return PublisherExcerpt(
            id = id,
            name = name
        )
    }
}