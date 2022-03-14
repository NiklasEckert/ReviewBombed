package de.niklaseckert.reviewbombed.ui.components.items

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import coil.compose.AsyncImage
import de.niklaseckert.reviewbombed.core.domain.model.ScreenshotExcerpt

/**
 * Composable to display a Screenshot Excerpt.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Composable
fun ScreenshotExcerptItem(
    screenshotExcerpt: ScreenshotExcerpt,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .aspectRatio(1.77f)
    ) {
        AsyncImage(
            model = screenshotExcerpt.screenshotUrl,
            contentDescription = null
        )
    }
}