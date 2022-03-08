package de.niklaseckert.reviewbombed.ui.game

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import de.niklaseckert.reviewbombed.feature_game.presentation.GameViewModel
import de.niklaseckert.reviewbombed.ui.game.components.DeveloperExcerptComponent
import de.niklaseckert.reviewbombed.ui.game.components.GameDetail
import de.niklaseckert.reviewbombed.ui.game.components.PublisherExcerptComponent
import java.time.format.DateTimeFormatter
import kotlin.math.min

@Composable
fun GameTab(
    gameViewModel: GameViewModel = hiltViewModel(),
    navController: NavController
) {
    val gameState = gameViewModel.state.value

    val rememberScrollState = rememberScrollState()

    Box(
        modifier = Modifier.background(MaterialTheme.colors.background)
    ) {
        gameState.gameItem?.let { game ->
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState)
            ) {
                GameDetail(
                    game = game,
                    rememberScrollState = rememberScrollState,
                    navController = navController
                )
            }
        }
    }
}