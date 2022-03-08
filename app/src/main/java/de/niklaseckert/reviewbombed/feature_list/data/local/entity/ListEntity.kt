package de.niklaseckert.reviewbombed.feature_list.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import de.niklaseckert.reviewbombed.core.domain.model.GameExcerpt
import de.niklaseckert.reviewbombed.feature_list.domain.model.ListModel

@Entity
data class ListEntity(
    @PrimaryKey val id: Long,
    val name: String,
    val description: String,
    val games: List<GameExcerpt>
) {
    fun toListModel(): ListModel {
        return ListModel(
            id = id,
            name = name,
            description = description,
            games = games
        )
    }
}