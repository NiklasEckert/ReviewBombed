package de.niklaseckert.reviewbombed.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import de.niklaseckert.reviewbombed.core.domain.model.PublisherExcerpt

@Entity
data class PublisherExcerptEntity(
    @PrimaryKey val id: Long,
    val name: String
) {
    fun toPublisherExcerpt(): PublisherExcerpt {
        return PublisherExcerpt(
            id = id,
            name = name
        )
    }
}