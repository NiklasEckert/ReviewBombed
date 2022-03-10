package de.niklaseckert.reviewbombed.ui.components.publisherexcerpts

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
import de.niklaseckert.reviewbombed.core.domain.model.PublisherExcerpt
import de.niklaseckert.reviewbombed.ui.theme.GeneralUnits

@Composable
fun PublisherExcerptListComponent(
    navController: NavController,
    publishers: List<PublisherExcerpt>
) {
    Spacer(modifier = Modifier.height(GeneralUnits.COMPONENT_SPACER_HEIGHT))
    Text(
        text = stringResource(id = R.string.publisher_comp_headline),
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    )
    Spacer(modifier = Modifier.height(GeneralUnits.BASE_PADDING))
    PublisherExcerptList(publishers = publishers, navController = navController)
}