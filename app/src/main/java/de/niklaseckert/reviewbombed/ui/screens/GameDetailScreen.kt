package de.niklaseckert.reviewbombed.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import de.niklaseckert.reviewbombed.feature_game.presentation.GameViewModel
import de.niklaseckert.reviewbombed.ui.components.gamedetail.GameDetail

@Composable
fun GameDetailScreen(
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