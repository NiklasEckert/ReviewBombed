package de.niklaseckert.reviewbombed.feature_game.presentation

import de.niklaseckert.reviewbombed.feature_game.domain.model.Game

/**
 * Data class that represents the Game State.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
data class GameState(

    /** Contains a Game which the Game State refers to. */
    val gameItem: Game? = null,

    /** Expresses if the Game State is loading or not. */
    val isLoading: Boolean = false
) {
}