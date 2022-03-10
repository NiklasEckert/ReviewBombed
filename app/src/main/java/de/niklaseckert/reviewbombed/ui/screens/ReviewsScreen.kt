package de.niklaseckert.reviewbombed.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import de.niklaseckert.reviewbombed.R
import de.niklaseckert.reviewbombed.core.presentation.ReviewExcerptItem
import de.niklaseckert.reviewbombed.feature_review.presentation.ReviewsViewModel

@Composable
fun ReviewsScreen(
    navController: NavController
) {
    val reviewsViewModel: ReviewsViewModel = hiltViewModel()
    val reviewsState = reviewsViewModel.state.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.review_headline),
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(horizontal = 8.dp)
        )

        LazyColumn() {
            items(reviewsState.reviewItems.size) { index ->
                val review = reviewsState.reviewItems[index]

                ReviewExcerptItem(review = review, navController = navController)

                Divider(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                )
            }
        }
    }
}