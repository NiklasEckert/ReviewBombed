package de.niklaseckert.reviewbombed.feature_review.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_review.data.remote.dto.ReviewPostDto
import de.niklaseckert.reviewbombed.feature_review.domain.use_case.DeleteReview
import de.niklaseckert.reviewbombed.feature_review.domain.use_case.GetReview
import de.niklaseckert.reviewbombed.feature_review.domain.use_case.PostReview
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Class which represents the View Model for Reviews.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@HiltViewModel
class ReviewViewModel @Inject constructor(

    /** Contains the Get Review Use Case. */
    private val getReview: GetReview,

    /** Contains the Post Review Use Case. */
    private val postReview: PostReview,

    /** Contains the Delete Review Use Case. */
    private val deleteReview: DeleteReview,

    /** Contains all saved states which the View Model can refer to. */
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    /** Represents the Review State. */
    private val _state = mutableStateOf(ReviewState())
    val state: State<ReviewState> = _state

    init {

        /**
         * Initialize saved state handle with the current Review id.
         */
        savedStateHandle.get<String>("reviewId")?.let { reviewId ->
            onGetReview(reviewId.toLong())
        }
    }

    /**
     * Method to get a specific Review.
     *
     * @param reviewId contains the id of a Game.
     */
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

    /**
     * Method to edit a Review.
     *
     * @param review contains the new Review.
     * @param gameId contains the id of the Game which the Review refers to.
     */
    fun onEditReview(review: ReviewPostDto, gameId: Long) {
        viewModelScope.launch {
            postReview(review = review, gameId = gameId)
        }
    }

    fun onDeleteReview(reviewId: Long) {
        viewModelScope.launch {
            deleteReview(reviewId = reviewId)
        }
    }
}