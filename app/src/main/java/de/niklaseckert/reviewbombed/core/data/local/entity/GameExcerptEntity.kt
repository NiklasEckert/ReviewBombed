package de.niklaseckert.reviewbombed.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import de.niklaseckert.reviewbombed.core.domain.model.GameExcerpt

@Entity
data class GameExcerptEntity(
    @PrimaryKey val id: Long? = null,
    val title: String,
    val coverUrl: String
) {
    fun toGameExcerpt(): GameExcerpt {
        return GameExcerpt(
            id = id ?: -1,
            title = title,
            coverUrl = coverUrl
        )
    }
}