package de.niklaseckert.reviewbombed.ui.game.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import de.niklaseckert.reviewbombed.core.domain.model.ScreenshotExcerpt
import de.niklaseckert.reviewbombed.core.presentation.ScreenshotExcerptItem

@Composable
fun ScreenshotExcerptList(
    screenshots: List<ScreenshotExcerpt>,
    navController: NavController
) {
    LazyRow {
        items(screenshots.size) { index ->
            ScreenshotExcerptItem(screenshotExcerpt = screenshots[index], navController = navController)

            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}