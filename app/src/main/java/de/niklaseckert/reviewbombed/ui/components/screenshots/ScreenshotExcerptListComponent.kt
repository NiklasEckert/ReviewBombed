package de.niklaseckert.reviewbombed.ui.components.screenshots

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import de.niklaseckert.reviewbombed.R
import de.niklaseckert.reviewbombed.core.domain.model.ScreenshotExcerpt
import de.niklaseckert.reviewbombed.ui.theme.GeneralUnits

/**
 * Composable which calls the Screenshot Excerpt List.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Composable
fun ScreenshotExcerptListComponent(
    screenshots: List<ScreenshotExcerpt>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
    ) {
        Spacer(modifier = Modifier.height(GeneralUnits.COMPONENT_SPACER_HEIGHT))
        Text(
            text = stringResource(id = R.string.screenshot_comp_headline),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(GeneralUnits.BASE_PADDING)
        )
        Spacer(modifier = Modifier.height(GeneralUnits.BASE_PADDING))
        ScreenshotExcerptList(screenshots = screenshots, navController = navController)
    }

}