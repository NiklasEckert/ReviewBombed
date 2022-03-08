package de.niklaseckert.reviewbombed.core.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import de.niklaseckert.reviewbombed.core.domain.model.GameExcerpt

@Composable
fun GameExcerptItem(
    gameExcerpt: GameExcerpt,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Card(
        modifier = modifier
            .width(128.dp)
            .height(180.dp)
            .shadow(2.dp, RoundedCornerShape(8.dp), false)
            .clickable { navController.navigate("game/" + gameExcerpt.id) }
    ) {
        AsyncImage(
            model = gameExcerpt.coverUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
    }
}