package de.niklaseckert.reviewbombed.feature_game.domain.model

import de.niklaseckert.reviewbombed.core.domain.model.DeveloperExcerpt
import de.niklaseckert.reviewbombed.core.domain.model.PublisherExcerpt
import de.niklaseckert.reviewbombed.core.domain.model.ScreenshotExcerpt
import java.time.LocalDate

class Game(
    val coverUrl: String,
    val date: LocalDate,
    val description: String,
    val developers: List<DeveloperExcerpt>,
    val id: Long,
    val publishers: List<PublisherExcerpt>,
    val title: String,
    val previewImageUrl: String,
    val screenshots: List<ScreenshotExcerpt>
) {

}