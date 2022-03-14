package de.niklaseckert.reviewbombed.feature_review.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.niklaseckert.reviewbombed.core.util.Resource
import de.niklaseckert.reviewbombed.feature_game.domain.model.Game
import de.niklaseckert.reviewbombed.feature_login.presentation.AccountViewModel
import de.niklaseckert.reviewbombed.feature_review.data.remote.dto.ReviewDto
import de.niklaseckert.reviewbombed.feature_review.data.remote.dto.ReviewPostDto
import de.niklaseckert.reviewbombed.feature_review.domain.use_case.FetchFromServer
import de.niklaseckert.reviewbombed.feature_review.domain.use_case.GetReviews
import de.niklaseckert.reviewbombed.feature_review.domain.use_case.PostReview
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

val ReviewsViewModelState = compositionLocalOf<ReviewsViewModel> { error("User State Context Not Found!") }

/**
 * Class which represents the View Model for a list of Reviews.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@HiltViewModel
class ReviewsViewModel @Inject constructor(

    /** Contains the Get Reviews Use Case. */
    private val getReviews: GetReviews,

    /** Contains the Post Reviews Use Case. */
    private val postReview: PostReview,

    /** Contains the FetchFromServerUseCase. */
    private val fetchFromServer: FetchFromServer
) : ViewModel() {

    /** Represents the Reviews State. */
    private val _state = mutableStateOf(ReviewsState())
    val state: State<ReviewsState> = _state

    init {

        /**
         * Initialize with all Reviews.
         */
//        fetchFromServerFun()
        onGetReviews()
    }

    /**
     * Method to get all Reviews.
     */
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

    /**
     * Method to post a Review.
     *
     * @param review contains the Review that should be posted.
     * @param gameId contains the id of the Game which the Review refers to.
     */
    fun onPostReview(review: ReviewPostDto, gameId: Long) {
        viewModelScope.launch {
            postReview(review = review, gameId = gameId)
//            onGetReviews()
        }
    }

    fun fetchFromServerFun() {
        viewModelScope.launch {
            fetchFromServer()
        }
    }
}