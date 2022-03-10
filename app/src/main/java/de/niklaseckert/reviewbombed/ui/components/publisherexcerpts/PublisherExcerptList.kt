package de.niklaseckert.reviewbombed.ui.components.publisherexcerpts

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import de.niklaseckert.reviewbombed.core.domain.model.PublisherExcerpt
import de.niklaseckert.reviewbombed.core.presentation.PublisherExcerptItem

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