package de.niklaseckert.reviewbombed.ui.components.developerexcerpts

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import de.niklaseckert.reviewbombed.core.domain.model.DeveloperExcerpt
import de.niklaseckert.reviewbombed.ui.components.items.DeveloperExcerptItem

/**
 * Composable to display a list of Developer Excerpts.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Composable
fun DevelopersExcerptList(
    developers: List<DeveloperExcerpt>,
    navController: NavController
) {
    Column() {
        developers.forEach{ dev ->
            DeveloperExcerptItem(developerExcerpt = dev, navController = navController)
            Divider()
        }
    }
}