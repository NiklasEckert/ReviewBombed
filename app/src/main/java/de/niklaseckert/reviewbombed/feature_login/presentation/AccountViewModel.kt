package de.niklaseckert.reviewbombed.feature_login.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_login.domain.use_case.PostLogin
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val postLogin: PostLogin,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(AccountState())
    val state: State<AccountState> = _state

    init {
//        onGetLogin()
    }

    fun onGetLogin(
        username: String,
        password: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        viewModelScope.launch {
            postLogin(username, password)
                .onEach { result ->
                    when(result) {
                        is Resource.Success -> {
                            _state.value = state.value.copy(
                                userItem = result.data,
                                isLoading = false
                            )
                            onSuccess()
                        }
                        is Resource.Error -> {
                            _state.value = state.value.copy(
                                userItem = result.data,
                                isLoading = false
                            )
                            onError()
                        }
                        is Resource.Loading -> {
                            _state.value = state.value.copy(
                                userItem = result.data,
                                isLoading = true
                            )
                        }
                    }
                }.launchIn(this)
        }
    }
}