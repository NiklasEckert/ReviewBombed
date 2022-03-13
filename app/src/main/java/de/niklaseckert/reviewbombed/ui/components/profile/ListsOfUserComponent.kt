package de.niklaseckert.reviewbombed.ui.components.profile

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
import de.niklaseckert.reviewbombed.core.domain.model.ListExcerpt
import de.niklaseckert.reviewbombed.ui.components.items.ListExcerptItem
import de.niklaseckert.reviewbombed.ui.theme.GeneralUnits

@Composable
fun ListsOfUserComponent(
    navController: NavController,
    lists: List<ListExcerpt>
) {

    Spacer(
        modifier = Modifier
            .height(GeneralUnits.COMPONENT_SPACER_HEIGHT)
    )

    Column() {
        Text(
            text = stringResource(id = R.string.bottom_nav_lists),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(GeneralUnits.COMPONENT_SPACER_HEIGHT))

        Column {
            lists.forEach { list ->
                ListExcerptItem(
                    listExcerpt = list,
                    navController = navController
                )
            }
        }
    }
}