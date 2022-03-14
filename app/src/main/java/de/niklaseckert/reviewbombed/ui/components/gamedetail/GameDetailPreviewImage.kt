package de.niklaseckert.reviewbombed.ui.components.gamedetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

/**
 * Composable which displays the preview image of a Game.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Composable
fun GameDetailPreviewImage(
    url: String,
    contentDescription: String? = null,
    imageModifier: Modifier,
    spacerModifier: Modifier
) {
    AsyncImage(
        model = url,
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = imageModifier
    )

    Spacer(
        modifier = spacerModifier
            .height(100.dp)
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        MaterialTheme.colors.background
                    )
                )
            )
    )
}