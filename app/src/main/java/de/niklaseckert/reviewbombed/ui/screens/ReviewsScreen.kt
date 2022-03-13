package de.niklaseckert.reviewbombed.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import de.niklaseckert.reviewbombed.R
import de.niklaseckert.reviewbombed.ui.components.items.ReviewExcerptItem
import de.niklaseckert.reviewbombed.feature_review.presentation.ReviewsViewModel
import de.niklaseckert.reviewbombed.ui.components.ReviewBombedCustomTopBar
import de.niklaseckert.reviewbombed.ui.components.general.ReviewBombedBottomNavigation
import de.niklaseckert.reviewbombed.ui.theme.GeneralUnits

@Composable
fun ReviewsScreen(
    navController: NavController
) {
    val reviewsViewModel: ReviewsViewModel = hiltViewModel()
    val reviewsState = reviewsViewModel.state.value

    Scaffold(
        topBar = {
            ReviewBombedCustomTopBar(text = stringResource(id = R.string.bottom_nav_reviews))
        },
        bottomBar = {
            ReviewBombedBottomNavigation(navController = navController)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                //.padding(vertical = 16.dp)
        ) {
            LazyColumn() {
                items(reviewsState.reviewItems.size) { index ->
                    val review = reviewsState.reviewItems[index]

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(GeneralUnits.BASE_PADDING)
                            //.height(256.dp)
                    ) {
                        ReviewExcerptItem(
                            review = review,
                            navController = navController,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    if (index < reviewsState.reviewItems.size-1) {
                        Divider(
                            modifier = Modifier
                                .padding(horizontal = 8.dp)
                        )
                    }
                }
            }
        }
    }
    

}