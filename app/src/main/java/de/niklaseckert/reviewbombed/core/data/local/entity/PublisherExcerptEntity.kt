package de.niklaseckert.reviewbombed.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import de.niklaseckert.reviewbombed.core.domain.model.PublisherExcerpt

/**
 * Data class which represents a Publisher Excerpt Entity.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Entity
data class PublisherExcerptEntity(

    /** Represents the id of the Publisher. */
    @PrimaryKey val id: Long,

    /** Represents the name of the Publisher. */
    val name: String
) {

    /**
     * Method that converts a Publisher Excerpt Entity into a Publisher Excerpt.
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