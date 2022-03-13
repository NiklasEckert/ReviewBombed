package de.niklaseckert.reviewbombed.feature_review.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_game.domain.model.Game
import de.niklaseckert.reviewbombed.feature_review.data.remote.dto.ReviewDto
import de.niklaseckert.reviewbombed.feature_review.data.remote.dto.ReviewPostDto
import de.niklaseckert.reviewbombed.feature_review.domain.model.Review
import de.niklaseckert.reviewbombed.feature_review.domain.use_case.GetReviews
import de.niklaseckert.reviewbombed.feature_review.domain.use_case.PostReview
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReviewsViewModel @Inject constructor(
    private val getReviews: GetReviews,
    private val postReview: PostReview
) : ViewModel() {

    private val _state = mutableStateOf(ReviewsState())
    val state: State<ReviewsState> = _state

    init {
        onGetReviews()
    }

    fun onGetReviews() {
        viewModelScope.launch {
            getReviews()
                .onEach { result ->
                when(result) {
                    is Resource.Success -> {
                        _state.value = state.value.copy(
                            reviewItems = result.data ?: emptyList(),
                            isLoading = false
                        )
                    }
                    is Resource.Error -> {
                        _state.value = state.value.copy(
                            reviewItems = result.data ?: emptyList(),
                            isLoading = false
                        )
                    }
                    is Resource.Loading -> {
                        _state.value = state.value.copy(
                            reviewItems = result.data ?: emptyList(),
                            isLoading = true
                        )
                    }
                }
            }.launchIn(this)
        }
    }

    fun onPostReview(review: ReviewPostDto, game: Game) {
        viewModelScope.launch {
            postReview(review = review, game = game)
//            onGetReviews()
        }
    }
}