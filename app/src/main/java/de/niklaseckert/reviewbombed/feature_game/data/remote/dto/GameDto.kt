package de.niklaseckert.reviewbombed.feature_game.data.remote.dto

import de.niklaseckert.reviewbombed.core.data.remote.dto.DeveloperExcerptDto
import de.niklaseckert.reviewbombed.core.data.remote.dto.PublisherExcerptDto
import de.niklaseckert.reviewbombed.feature_game.data.local.entity.GameEntity
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class GameDto(
    val coverUrl: String,
    val date: String,
    val description: String,
    val developers: List<DeveloperExcerptDto>,
    val id: Long,
    val publishers: List<PublisherExcerptDto>,
    val title: String,
    val previewImageUrl: String
) {
    fun toGameEntity(): GameEntity {
        return GameEntity(
            id = id,
            title = title,
            description = description,
            date = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            coverUrl = coverUrl,
            developers = developers.map { it.toDeveloperExcerpt() },
            publishers = publishers.map { it.toPublisherExcerpt() },
            previewImageUrl = previewImageUrl
        )
    }
}