package de.niklaseckert.reviewbombed.feature_list.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_list.domain.use_case.GetList
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Class which represents the View Model for Lists.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@HiltViewModel
class ListViewModel @Inject constructor(

    /** Contains the Get List Use Case. */
    private val getList: GetList,

    /** Contains all saved states which the View Model can refer to. */
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    /** Represents the List State. */
    private val _state = mutableStateOf(ListState())
    val state: State<ListState> = _state

    init {

        /**
         * Initialize saved state handle with current List id.
         */
        savedStateHandle.get<String>("listId")?.let { listId ->
            onGetListModel(listId.toLong())
        }
    }

    /**
     * Method to a specific List.
     *
     * @param id contains the id of a List.
     */
    fun onGetListModel(id: Long) {
        viewModelScope.launch {
            getList(id)
                .onEach { result ->
                    when(result) {
                        is Resource.Success -> {
                            _state.value = state.value.copy(
                                listModelItem = result.data,
                                isLoading = false
                            )
                        }
                        is Resource.Error -> {
                            _state.value = state.value.copy(
                                listModelItem = result.data,
                                isLoading = false
                            )
                        }
                        is Resource.Loading -> {
                            _state.value = state.value.copy(
                                listModelItem = result.data,
                                isLoading = true
                            )
                        }
                    }
                }.launchIn(this)
        }
    }
}