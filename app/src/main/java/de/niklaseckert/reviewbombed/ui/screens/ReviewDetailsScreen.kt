package de.niklaseckert.reviewbombed.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import de.niklaseckert.reviewbombed.ui.components.items.GameExcerptItem
import de.niklaseckert.reviewbombed.feature_review.presentation.ReviewViewModel
import de.niklaseckert.reviewbombed.ui.components.ReviewBombedRatingBar
import java.time.format.DateTimeFormatter

@Composable
fun ReviewDetailsScreen(
    reviewViewModel: ReviewViewModel = hiltViewModel(),
    navController: NavController
) {
    val reviewState = reviewViewModel.state.value

    Column(
        modifier = Modifier
            .padding(all = 8.dp)
    ) {
        reviewState.reviewItem?.let { review ->
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .weight(weight = 1f, fill = true)
                ) {
                    Text(
                        text = review.title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 36.sp
                    )
                    Row() {
                        ReviewBombedRatingBar(rating = review.rate)
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = review.reviewDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    AsyncImage(
                        model = review.user.profileImageUrl,
                        contentDescription = null,
                        modifier = Modifier.size(64.dp)
                    )

                    Text(
                        text = review.user.name
                    )
                }

                Column(
                    modifier = Modifier
                        .padding(end = 8.dp)
                ) {
                    GameExcerptItem(gameExcerpt = review.gameExcerpt, navController = navController)
                }
            }


            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = review.reviewText
            )

            Spacer(modifier = Modifier.height(8.dp))
            Divider()

        }
    }
}