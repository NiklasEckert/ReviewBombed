package de.niklaseckert.reviewbombed.ui.components.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import de.niklaseckert.reviewbombed.R
import de.niklaseckert.reviewbombed.feature_review.domain.model.Review
import de.niklaseckert.reviewbombed.ui.components.items.ReviewExcerptItem
import de.niklaseckert.reviewbombed.ui.theme.GeneralUnits

@Composable
fun ReviewsOfUserComponent(
    navController: NavController,
    reviews: List<Review>
) {
    val configuration = LocalConfiguration.current

    Spacer(
        modifier = Modifier
            .height(GeneralUnits.COMPONENT_SPACER_HEIGHT)
    )
    Column() {
        Text(
            text = stringResource(id = R.string.review_headline),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        
        Spacer(modifier = Modifier.height(GeneralUnits.COMPONENT_SPACER_HEIGHT))

        LazyRow {
            items(reviews.size) { index ->
                Card(
                    modifier = Modifier
                        .fillMaxHeight()
                ) {
                    ReviewExcerptItem(
                        review = reviews[index],
                        navController = navController,
                        modifier = Modifier
                            .width(configuration.screenWidthDp.dp - GeneralUnits.DOUBLE_SPACER_WIDTH)
                            .fillMaxHeight()
                    )
                }
                
                Spacer(modifier = Modifier.width(GeneralUnits.BASE_PADDING))
            }
        }
    }
}