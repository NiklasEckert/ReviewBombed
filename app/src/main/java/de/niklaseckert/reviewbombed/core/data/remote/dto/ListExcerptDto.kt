package de.niklaseckert.reviewbombed.core.data.remote.dto

import de.niklaseckert.reviewbombed.core.data.local.entity.ListExcerptEntity
import de.niklaseckert.reviewbombed.core.domain.model.ListExcerpt

/**
 * Data class which represents the data transfer object for List Excerpt.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
data class ListExcerptDto(

    /** Represents the id of the List. */
    val id: Long,

    /** Represents the name of the List. */
    val name: String,

    /** Represents the description of the List. */
    val description: String
) {

    /**
     * Method that converts a List Excerpt Dto into a List Excerpt Entity.
     *
     * @return the resulting List Excerpt Entity.
     */
    fun toListExcerptEntity(): ListExcerptEntity {
        return ListExcerptEntity(
            id = id,
            name = name,
            description = description
        )
    }

    /**
     * Method that converts a List Excerpt Dto into a List Excerpt.
     *
     * @return the resulting List Excerpt.
     */
    fun toListExcerpt(): ListExcerpt {
        return ListExcerpt(
            id = id,
            name = name,
            description = description
        )
    }
}