package de.niklaseckert.reviewbombed.feature_game.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_developer.presentation.DeveloperViewModel
import de.niklaseckert.reviewbombed.feature_game.domain.use_case.GetGame
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Class which represents the View Model for Games.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@HiltViewModel
class GameViewModel @Inject constructor(

    /** Contains the Get Game Use Case. */
    private val getGame: GetGame,

    /** Contains all saved states which the View Model can refer to. */
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    /** Represents the Game State. */
    private val _state = mutableStateOf(GameState())
    val state: State<GameState> = _state

    init {

        /**
         * Initialize saved state handle with the current Game id.
         */
        savedStateHandle.get<String>("gameId")?.let { gameId ->
            onGetGame(gameId.toLong())
        }
    }

    /**
     * Method to get a specific Game.
     *
     * @param id contains the id of a Game.
     */
    fun onGetGame(id: Long) {
        viewModelScope.launch {
            getGame(id)
                .onEach { result ->
                    when(result) {
                        is Resource.Success -> {
                            _state.value = state.value.copy(
                                gameItem = result.data,
                                isLoading = false
                            )
                        }
                        is Resource.Error -> {
                            _state.value = state.value.copy(
                                gameItem = result.data,
                                isLoading = false
                            )
                        }
                        is Resource.Loading -> {
                            _state.value = state.value.copy(
                                gameItem = result.data,
                                isLoading = true
                            )
                        }
                    }
                }.launchIn(this)
        }
    }
}