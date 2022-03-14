package de.niklaseckert.reviewbombed.feature_list.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_list.domain.use_case.GetListExcerpts
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Class which represents the View Model for List Excerpts.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@HiltViewModel
class ListExcerptViewModel @Inject constructor(

    /** Contains the Get List Excerpts Use Case. */
    private val getListExcerpts: GetListExcerpts
) : ViewModel() {

    /** Represents the List Excerpt State. */
    private val _state = mutableStateOf(ListExcerptState())
    val state: State<ListExcerptState> = _state

    init {

        /**
         * Initialize with the List Excerpts.
         */
        onGetListExcerpts()
    }

    /**
     * Method to get all List Excerpts.
     */
    fun onGetListExcerpts() {
        viewModelScope.launch {
            getListExcerpts()
                .onEach { result ->
                    when(result) {
                        is Resource.Success -> {
                            _state.value = state.value.copy(
                                listExcerptItems = result.data ?: emptyList(),
                                isLoading = false
                            )
                        }
                        is Resource.Error -> {
                            _state.value = state.value.copy(
                                listExcerptItems = result.data ?: emptyList(),
                                isLoading = false
                            )
                        }
                        is Resource.Loading -> {
                            _state.value = state.value.copy(
                                listExcerptItems = result.data ?: emptyList(),
                                isLoading = true
                            )
                        }
                    }
                }.launchIn(this)
        }
    }
}