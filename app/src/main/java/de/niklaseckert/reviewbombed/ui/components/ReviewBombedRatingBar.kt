package de.niklaseckert.reviewbombed.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Composable to display the rating bar.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Composable
fun ReviewBombedRatingBar(
    rating: Int
) {
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.Bottom
    ) {
        for (i in 1..5) {
            var tint = Color.DarkGray
            if (i <= rating) {
                tint = Color(red = 255, green = 165, blue = 0)
            }

            Icon(
                imageVector = Icons.Filled.Star,
                tint = tint,
                contentDescription = null,
                modifier = Modifier
                    .size(16.dp)
            )
        }
    }
}