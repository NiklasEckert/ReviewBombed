package de.niklaseckert.reviewbombed.ui.components.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import de.niklaseckert.reviewbombed.feature_review.domain.model.Review
import de.niklaseckert.reviewbombed.ui.components.ReviewBombedRatingBar
import java.time.format.DateTimeFormatter

@Composable
fun ReviewExcerptItem(
    review: Review,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .clickable { navController.navigate("review/" + review.id) }
                .padding(all = 8.dp)
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Text(
                text = review.title,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ReviewBombedRatingBar(rating = review.rate)

                Text(
                    text = review.user.name
                )

                Text(
                    text = review.reviewDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(
                modifier = Modifier
                    .height(4.dp)
            )

            Divider()

            Spacer(
                modifier = Modifier
                    .height(4.dp)
            )

            Row() {
                Column(
                    modifier = Modifier
                        .padding(end = 16.dp)
                ) {
                    GameExcerptItem(gameExcerpt = review.gameExcerpt, navController = navController)
                }

                Column() {
                    var text = review.reviewText
                    if (text.length > 240) {
                        text = text.substring(startIndex = 0, endIndex = 240)
                        text = text.substring(
                            startIndex = 0,
                            endIndex = text.lastIndexOf(" ")
                        ) + "(...)"
                    }

                    Text(
                        text = text
                    )
                }
            }
        }
    }
}