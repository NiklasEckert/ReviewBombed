package de.niklaseckert.reviewbombed.ui.components.screenshots

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import de.niklaseckert.reviewbombed.core.domain.model.ScreenshotExcerpt
import de.niklaseckert.reviewbombed.ui.components.items.ScreenshotExcerptItem
import de.niklaseckert.reviewbombed.ui.theme.GeneralUnits

@Composable
fun ScreenshotExcerptList(
    screenshots: List<ScreenshotExcerpt>,
    navController: NavController
) {
    val configuration = LocalConfiguration.current
    LazyRow {
        items(screenshots.size) { index ->
            ScreenshotExcerptItem(
                screenshotExcerpt = screenshots[index],
                navController = navController,
                modifier = Modifier
                    .width(configuration.screenWidthDp.dp - GeneralUnits.BASE_PADDING - GeneralUnits.BASE_PADDING)
            )

            if (index < screenshots.size-1) {
                Spacer(modifier = Modifier.width(GeneralUnits.BASE_PADDING))
            }
        }
    }
}