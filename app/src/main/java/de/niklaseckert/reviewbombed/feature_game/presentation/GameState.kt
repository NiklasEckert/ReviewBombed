package de.niklaseckert.reviewbombed.feature_game.presentation

import de.niklaseckert.reviewbombed.feature_game.domain.model.Game

data class GameState(
    val gameItem: Game? = null,
    val isLoading: Boolean = false
) {
}