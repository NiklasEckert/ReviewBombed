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

@HiltViewModel
class ListExcerptViewModel @Inject constructor(
    private val getListExcerpts: GetListExcerpts
) : ViewModel() {

    private val _state = mutableStateOf(ListExcerptState())
    val state: State<ListExcerptState> = _state

    init {
        onGetListExcerpts()
    }

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