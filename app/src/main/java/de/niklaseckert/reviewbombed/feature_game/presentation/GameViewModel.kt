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

@HiltViewModel
class GameViewModel @Inject constructor(
    private val getGame: GetGame,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(GameState())
    val state: State<GameState> = _state

    init {
        savedStateHandle.get<String>("gameId")?.let { gameId ->
            onGetGame(gameId.toLong())
        }
    }

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