package de.niklaseckert.reviewbombed.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import de.niklaseckert.reviewbombed.core.domain.model.GameExcerpt

@Entity(primaryKeys = ["id", "scope"])
data class GameExcerptEntity(
    val id: Long,
    val title: String,
    val coverUrl: String,
    val scope: GameExcerptScope
) {
    fun toGameExcerpt(): GameExcerpt {
        return GameExcerpt(
            id = id,
            title = title,
            coverUrl = coverUrl
        )
    }
}

enum class GameExcerptScope {
    NONE,
    CURRENTLY_PLAYING,
    FRIENDS_PLAYING,
    FRIENDS_FINISHED
}