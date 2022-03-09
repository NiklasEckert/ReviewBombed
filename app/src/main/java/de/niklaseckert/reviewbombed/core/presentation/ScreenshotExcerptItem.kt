package de.niklaseckert.reviewbombed.core.presentation

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import de.niklaseckert.reviewbombed.core.domain.model.ScreenshotExcerpt

@Composable
fun ScreenshotExcerptItem(
    screenshotExcerpt: ScreenshotExcerpt,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .height(200.dp)
            .width(355.dp)
    ) {
        AsyncImage(
            model = screenshotExcerpt.screenshotUrl,
            contentDescription = null
        )
    }
}