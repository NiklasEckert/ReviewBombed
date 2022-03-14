package de.niklaseckert.reviewbombed.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import de.niklaseckert.reviewbombed.R
import de.niklaseckert.reviewbombed.core.presentation.TopBarState
import de.niklaseckert.reviewbombed.ui.components.items.ReviewExcerptItem
import de.niklaseckert.reviewbombed.feature_review.presentation.ReviewsViewModel
import de.niklaseckert.reviewbombed.feature_review.presentation.ReviewsViewModelState
import de.niklaseckert.reviewbombed.ui.components.ReviewBombedCustomTopBar
import de.niklaseckert.reviewbombed.ui.components.general.ReviewBombedBottomNavigation
import de.niklaseckert.reviewbombed.ui.theme.GeneralUnits

/**
 * Composable to display all Reviews.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Composable
fun ReviewsScreen(
    navController: NavController
) {
//    val reviewsViewModel: ReviewsViewModel = hiltViewModel()
    val reviewsViewModel = ReviewsViewModelState.current
    val reviewsState = reviewsViewModel.state.value

    val topBarViewModel = TopBarState.current
    topBarViewModel.topBarText = stringResource(id = R.string.bottom_nav_reviews)
    topBarViewModel.isEnabled = true

    topBarViewModel.isTopBarActionEnabled = true
    topBarViewModel.topBarActionIcon = Icons.Filled.Refresh
    topBarViewModel.topBarActionFunction = {
        reviewsViewModel.onGetReviews()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = topBarViewModel.topBarPadding
            )
    ) {
        LazyColumn() {
            items(reviewsState.reviewItems.size) { index ->
                val review = reviewsState.reviewItems[index]

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(GeneralUnits.BASE_PADDING)
                ) {
                    ReviewExcerptItem(
                        review = review,
                        navController = navController,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                if (index < reviewsState.reviewItems.size - 1) {
                    Divider(
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                    )
                }
            }
        }
    }


}