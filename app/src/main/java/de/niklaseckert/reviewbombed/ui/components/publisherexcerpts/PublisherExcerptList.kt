package de.niklaseckert.reviewbombed.ui.components.publisherexcerpts

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import de.niklaseckert.reviewbombed.core.domain.model.PublisherExcerpt
import de.niklaseckert.reviewbombed.ui.components.items.PublisherExcerptItem

/**
 * Composable to display a list of Publisher Excerpts.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Composable
fun PublisherExcerptList(
    publishers: List<PublisherExcerpt>,
    navController: NavController
) {
    Column() {
        publishers.forEach{ pub ->
            PublisherExcerptItem(publisherExcerpt = pub, navController = navController)
            Divider()
        }
    }
}