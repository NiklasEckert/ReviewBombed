package de.niklaseckert.reviewbombed.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import de.niklaseckert.reviewbombed.core.domain.model.DeveloperExcerpt

@Entity
data class DeveloperExcerptEntity(
    @PrimaryKey val id: Long,
    val name: String
) {
    fun toDeveloperExcerpt(): DeveloperExcerpt {
        return DeveloperExcerpt(
            id = id,
            name = name
        )
    }
}