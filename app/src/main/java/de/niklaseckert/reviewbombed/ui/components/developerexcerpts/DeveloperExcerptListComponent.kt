package de.niklaseckert.reviewbombed.ui.components.developerexcerpts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import de.niklaseckert.reviewbombed.R
import de.niklaseckert.reviewbombed.core.domain.model.DeveloperExcerpt
import de.niklaseckert.reviewbombed.ui.theme.GeneralUnits

/**
 * Composable which calls the Developer Excerpt List.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Composable
fun DeveloperExcerptListComponent(
    navController: NavController,
    developers: List<DeveloperExcerpt>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Spacer(modifier = Modifier.height(GeneralUnits.COMPONENT_SPACER_HEIGHT))
        Text(
            text = stringResource(id = R.string.developer_comp_headline),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(GeneralUnits.BASE_PADDING))
        DevelopersExcerptList(developers = developers, navController = navController)
    }

}