package de.niklaseckert.reviewbombed.feature_home.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_home.domain.use_case.GetFriendsFinished
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Class which represents the View Model for finished Games.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@HiltViewModel
class FriendsFinishedViewModel @Inject constructor(

    /** Contains the Get Friends Finished Use Case. */
    private val getFriendsFinished: GetFriendsFinished
): ViewModel() {

    /** Represents the State. */
    private val _state = mutableStateOf(GameExcerptListState())
    val state: State<GameExcerptListState> = _state

    /** Represents the event flow. */
    private val _eventFlow = MutableSharedFlow<UIEvent>()

    init {

        /**
         * Initialize with the Games that friends finished.
         */
        loadFriendsFinished()
    }

    /**
     * Method to get all Games that friends finished.
     */
    fun loadFriendsFinished() {
        viewModelScope.launch {
            getFriendsFinished()
                .onEach { result ->
                    when(result) {
                        is Resource.Success -> {
                            _state.value = state.value.copy(
                                gameExcerptItems = result.data ?: emptyList(),
                                isLoading = false
                            )
                        }
                        is Resource.Error -> {
                            _state.value = state.value.copy(
                                gameExcerptItems = result.data ?: emptyList(),
                                isLoading = false
                            )
                            _eventFlow.emit(UIEvent.ShowSnackbar(
                                result.message ?: "Unknown error"
                            ))
                        }
                        is Resource.Loading -> {
                            _state.value = state.value.copy(
                                gameExcerptItems = result.data ?: emptyList(),
                                isLoading = true
                            )
                        }
                    }

                }.launchIn(this)
        }
    }

    /**
     * Sealed class to show a Snackbar.
     */
    sealed class UIEvent {
        data class ShowSnackbar(val message: String): UIEvent()
    }
}