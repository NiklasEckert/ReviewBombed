package de.niklaseckert.reviewbombed.feature_review.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_review.data.remote.dto.ReviewPostDto
import de.niklaseckert.reviewbombed.feature_review.domain.use_case.GetReview
import de.niklaseckert.reviewbombed.feature_review.domain.use_case.PostReview
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReviewViewModel @Inject constructor(
    private val getReview: GetReview,
    private val postReview: PostReview,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(ReviewState())
    val state: State<ReviewState> = _state

    init {
        savedStateHandle.get<String>("reviewId")?.let { reviewId ->
            onGetReview(reviewId.toLong())
        }
    }

    fun onGetReview(reviewId: Long) {
        viewModelScope.launch {
            getReview(reviewId = reviewId)
                .onEach { result ->
                    when(result) {
                        is Resource.Success -> {
                            _state.value = state.value.copy(
                                reviewItem = result.data,
                                isLoading = false
                            )
                        }
                        is Resource.Error -> {
                            _state.value = state.value.copy(
                                reviewItem = result.data,
                                isLoading = false
                            )
                        }
                        is Resource.Loading -> {
                            _state.value = state.value.copy(
                                reviewItem = result.data,
                                isLoading = true
                            )
                        }
                    }
                }.launchIn(this)
        }
    }

    fun onEditReview(review: ReviewPostDto, gameId: Long) {
        viewModelScope.launch {
            postReview(review = review, gameId = gameId)
        }
    }
}