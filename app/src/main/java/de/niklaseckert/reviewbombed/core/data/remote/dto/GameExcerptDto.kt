package de.niklaseckert.reviewbombed.core.data.remote.dto

import de.niklaseckert.reviewbombed.core.data.local.entity.GameExcerptEntity
import de.niklaseckert.reviewbombed.core.data.local.entity.GameExcerptScope
import de.niklaseckert.reviewbombed.core.domain.model.GameExcerpt

/**
 * Data class which represents the data transfer object for a Game Excerpt.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
data class GameExcerptDto(

    /** Represents the id of a Game. */
    val id: Long,

    /** Represents the title of a Game. */
    val title: String,

    /** Represents the url for the Game cover. */
    val coverUrl: String,

    /** Represents the url for the preview image of the Game. */
    val previewImageUrl: String
) {

    /**
     * Method that converts a Game Excerpt Dto into a Game Excerpt Entity.
     *
     * @param scope contains the scope the Game belongs to.
     * @return the resulting Game Excerpt Entity.
     */
    fun toGameExcerptEntity(scope: GameExcerptScope): GameExcerptEntity {
        return GameExcerptEntity(
            id = id,
            title = title,
            coverUrl = coverUrl,
            previewImageUrl = previewImageUrl,
            scope = scope
        )
    }

    /**
     * Method that converts a Game Excerpt Dto into a Game Excerpt.
     *
     * @return the resulting Game Excerpt.
     */
    fun toGameExcerpt(): GameExcerpt {
        return GameExcerpt(
            id = id,
            title = title,
            coverUrl = coverUrl,
            previewImageUrl = previewImageUrl
        )
    }
}