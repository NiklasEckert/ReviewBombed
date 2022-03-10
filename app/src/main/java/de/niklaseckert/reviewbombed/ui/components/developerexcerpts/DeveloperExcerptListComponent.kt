package de.niklaseckert.reviewbombed.ui.components.developerexcerpts

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
import de.niklaseckert.reviewbombed.core.domain.model.DeveloperExcerpt

@Composable
fun DeveloperExcerptListComponent(
    navController: NavController,
    developers: List<DeveloperExcerpt>
) {
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = stringResource(id = R.string.developer_comp_headline),
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    )
    Spacer(modifier = Modifier.height(8.dp))
    DevelopersExcerptList(developers = developers, navController = navController)
}