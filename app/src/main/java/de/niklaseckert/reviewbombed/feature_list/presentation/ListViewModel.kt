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

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getList: GetList,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(ListState())
    val state: State<ListState> = _state

    init {
        savedStateHandle.get<String>("listId")?.let { listId ->
            onGetListModel(listId.toLong())
        }
    }

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