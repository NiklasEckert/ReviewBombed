package de.niklaseckert.reviewbombed.ui.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.niklaseckert.reviewbombed.core.presentation.GameExcerptItem
import de.niklaseckert.reviewbombed.feature_home.presentation.AllCurrentlyPlayingState

@Composable
fun CurrentlyPlayingList(
    currentlyPlayingState: AllCurrentlyPlayingState
) {
    LazyRow(
        modifier = Modifier.fillMaxSize()
    ) {
        items(currentlyPlayingState.gameExcerptItems.size) { index ->
            val gameExcerpt = currentlyPlayingState.gameExcerptItems[index]
            if (index > 0) {
                Spacer(modifier = Modifier.width(8.dp))
            }
            GameExcerptItem(gameExcerpt = gameExcerpt)
        }
    }
}