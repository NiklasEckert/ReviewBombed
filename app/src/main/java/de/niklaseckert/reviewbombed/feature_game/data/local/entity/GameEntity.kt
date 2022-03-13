package de.niklaseckert.reviewbombed.feature_game.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import de.niklaseckert.reviewbombed.core.domain.model.DeveloperExcerpt
import de.niklaseckert.reviewbombed.core.domain.model.PublisherExcerpt
import de.niklaseckert.reviewbombed.core.domain.model.ScreenshotExcerpt
import de.niklaseckert.reviewbombed.feature_game.domain.model.Game
import java.time.LocalDate

/**
 * Data class which represents a Game Entity.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Entity
data class GameEntity(

    /** Represents the url of the Game cover. */
    val coverUrl: String,

    /** Represents the date when the Game got published. */
    val date: LocalDate,

    /** Represents the description of the Game. */
    val description: String,

    /** Represents the Developers of the Game. */
    val developers: List<DeveloperExcerpt>,

    /** Represents the id of the Game. */
    @PrimaryKey val id: Long,

    /** Represents the Publishers of the Game. */
    val publishers: List<PublisherExcerpt>,

    /** Represents the title of the Game. */
    val title: String,

    /** Represents the url for the preview image of the Game. */
    val previewImageUrl: String,

    /** Represents the Screenshots for the Game. */
    val screenshots: List<ScreenshotExcerpt>
) {

    /**
     * Method that converts a Game Entity into a Game.
     *
     * @return the resulting Game.
     */
    fun toGame(): Game {
        return Game(
            id = id,
            title = title,
            date = date,
            description = description,
            coverUrl = coverUrl,
            developers = developers,
            publishers = publishers,
            previewImageUrl = previewImageUrl,
            screenshots = screenshots
        )
    }
}