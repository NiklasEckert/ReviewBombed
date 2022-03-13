package de.niklaseckert.reviewbombed.core.data.local.entity

import androidx.room.Entity
import de.niklaseckert.reviewbombed.core.domain.model.GameExcerpt

/**
 * Data class which represents a Game Excerpt Entity.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Entity(primaryKeys = ["id", "scope"])
data class GameExcerptEntity(

    /** Represents the id of the Game. */
    val id: Long,

    /** Represents the title of the Game. */
    val title: String,

    /** Represents the url for the Game cover. */
    val coverUrl: String,

    /** Represents the scope which the Game belongs to. */
    val scope: GameExcerptScope,

    /** Represents the url for the preview image of the Game. */
    val previewImageUrl: String
) {

    /**
     * Method that converts a Game Excerpt Entity into a Game Excerpt.
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

/**
 * Enum class which represents the scope which a Game can belong to.
 */
enum class GameExcerptScope {
    NONE,
    CURRENTLY_PLAYING,
    FRIENDS_PLAYING,
    FRIENDS_FINISHED
}