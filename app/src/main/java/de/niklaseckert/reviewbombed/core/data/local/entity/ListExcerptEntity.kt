package de.niklaseckert.reviewbombed.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import de.niklaseckert.reviewbombed.core.domain.model.ListExcerpt

@Entity
data class ListExcerptEntity(
    @PrimaryKey val id: Long,
    val name: String,
    val description: String
) {
   fun toListExcerpt(): ListExcerpt {
       return ListExcerpt(
           id = id,
           name = name,
           description = description
       )
   }
}