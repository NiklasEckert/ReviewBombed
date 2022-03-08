package de.niklaseckert.reviewbombed.ui.game.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import de.niklaseckert.reviewbombed.R
import de.niklaseckert.reviewbombed.core.domain.model.PublisherExcerpt

@Composable
fun PublisherExcerptComponent(
    navController: NavController,
    publishers: List<PublisherExcerpt>
) {
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = stringResource(id = R.string.publisher_comp_headline),
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    )
    Spacer(modifier = Modifier.height(8.dp))
    PublishersExcerptList(publishers = publishers, navController = navController)
}