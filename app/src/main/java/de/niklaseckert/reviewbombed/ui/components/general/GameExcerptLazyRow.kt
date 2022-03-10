package de.niklaseckert.reviewbombed.ui.components.general

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import de.niklaseckert.reviewbombed.ui.components.items.GameExcerptItem
import de.niklaseckert.reviewbombed.feature_home.presentation.GameExcerptListState

@Composable
fun GameExcerptLazyRow(
    gameExcerptListState: GameExcerptListState,
    navController: NavController
) {
    LazyRow {
        items(gameExcerptListState.gameExcerptItems.size) { index ->
            val gameExcerpt = gameExcerptListState.gameExcerptItems[index]
            if (index == 0) {
                Spacer(modifier = Modifier.width(8.dp))
            }
            
            GameExcerptItem(gameExcerpt = gameExcerpt, navController = navController)

            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}