package de.niklaseckert.reviewbombed.feature_profile.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_profile.domain.use_case.GetOwnProfile
import de.niklaseckert.reviewbombed.feature_profile.domain.use_case.GetProfile
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Class which represents the View Model for Profiles.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@HiltViewModel
class ProfileViewModel @Inject constructor(

    /** Contains the Get Profile Use Case. */
    private val getProfile: GetProfile,

    /** Contains the Get Own Profile Use Case. */
    private val getOwnProfile: GetOwnProfile,
) : ViewModel() {

    /** Represents the Profile State. */
    private val _state = mutableStateOf(ProfileState())
    val state: State<ProfileState> = _state

    init {

        /**
         * Initialize with the own Profile.
         */
        onGetOwnProfile()
    }

    /**
     * Method to get the own Profile.
     */
    fun onGetOwnProfile() {
        viewModelScope.launch {
            getOwnProfile()
                .onEach { result ->
                    when(result) {
                        is Resource.Success -> {
                            _state.value = state.value.copy(
                                profileItem = result.data,
                                isLoading = false
                            )
                        }
                        is Resource.Error -> {
                            _state.value = state.value.copy(
                                profileItem = result.data,
                                isLoading = false
                            )
                        }
                        is Resource.Loading -> {
                            _state.value = state.value.copy(
                                profileItem = result.data,
                                isLoading = true
                            )
                        }
                    }
                }.launchIn(this)
        }
    }

    /**
     * Method to get a specific Profile.
     *
     * @param id contains the id of a Game.
     */
    fun onGetProfile(id: Long) {
        viewModelScope.launch {
            getProfile(id)
                .onEach { result ->
                    when(result) {
                        is Resource.Success -> {
                            _state.value = state.value.copy(
                                profileItem = result.data,
                                isLoading = false
                            )
                        }
                        is Resource.Error -> {
                            _state.value = state.value.copy(
                                profileItem = result.data,
                                isLoading = false
                            )
                        }
                        is Resource.Loading -> {
                            _state.value = state.value.copy(
                                profileItem = result.data,
                                isLoading = true
                            )
                        }
                    }
                }.launchIn(this)
        }
    }
}