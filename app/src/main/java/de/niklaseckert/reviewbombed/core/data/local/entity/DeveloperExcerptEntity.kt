package de.niklaseckert.reviewbombed.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import de.niklaseckert.reviewbombed.core.domain.model.DeveloperExcerpt

/**
 * Data class which represents a Developer Excerpt.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Entity
data class DeveloperExcerptEntity(

    /** Represents the id of the Developer. */
    @PrimaryKey val id: Long,

    /** Represents the name of the Developer. */
    val name: String
) {

    /**
     * Method that converts a Developer Excerpt Entity into a Developer Excerpt.
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