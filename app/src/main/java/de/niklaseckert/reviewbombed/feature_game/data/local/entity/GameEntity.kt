package de.niklaseckert.reviewbombed.feature_game.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import de.niklaseckert.reviewbombed.core.data.local.entity.DeveloperExcerptEntity
import de.niklaseckert.reviewbombed.core.data.local.entity.PublisherExcerptEntity
import de.niklaseckert.reviewbombed.core.data.remote.dto.DeveloperExcerptDto
import de.niklaseckert.reviewbombed.core.data.remote.dto.PublisherExcerptDto
import de.niklaseckert.reviewbombed.core.domain.model.DeveloperExcerpt
import de.niklaseckert.reviewbombed.core.domain.model.PublisherExcerpt
import de.niklaseckert.reviewbombed.core.domain.model.ScreenshotExcerpt
import de.niklaseckert.reviewbombed.feature_game.domain.model.Game
import java.time.LocalDate

@Entity
data class GameEntity(
    val coverUrl: String,
    val date: LocalDate,
    val description: String,
    val developers: List<DeveloperExcerpt>,
    @PrimaryKey val id: Long,
    val publishers: List<PublisherExcerpt>,
    val title: String,
    val previewImageUrl: String,
    val screenshots: List<ScreenshotExcerpt>
) {
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