package de.niklaseckert.reviewbombed.ui.components.gamedetail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import de.niklaseckert.reviewbombed.R
import de.niklaseckert.reviewbombed.feature_game.domain.model.Game
import de.niklaseckert.reviewbombed.feature_review.data.remote.dto.ReviewDto
import de.niklaseckert.reviewbombed.feature_review.data.remote.dto.ReviewPostDto
import de.niklaseckert.reviewbombed.feature_review.domain.model.Review
import de.niklaseckert.reviewbombed.feature_review.presentation.ReviewViewModel
import de.niklaseckert.reviewbombed.feature_review.presentation.ReviewsViewModel
import de.niklaseckert.reviewbombed.ui.components.ReviewBombedRatingBar
import de.niklaseckert.reviewbombed.ui.components.general.GameDetailHeadline
import de.niklaseckert.reviewbombed.ui.components.items.GameExcerptItem
import de.niklaseckert.reviewbombed.ui.theme.GeneralUnits
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AddReviewSheet(
    game: Game,
    sheetState: ModalBottomSheetState,
    reviewsViewModel: ReviewsViewModel = hiltViewModel(),
) {

    var reviewTitle by remember { mutableStateOf("") }
    var reviewText by remember { mutableStateOf("") }

    val configuration = LocalConfiguration.current

    var sliderPosition by remember { mutableStateOf(0f) }

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(configuration.screenHeightDp.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier
                .padding(GeneralUnits.BASE_PADDING)
                .fillMaxWidth()
                .padding(GeneralUnits.BASE_PADDING),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    scope.launch {
                        sheetState.hide()
                        reviewText = ""
                        reviewTitle = ""
                        sliderPosition = 0f
                    }
                }
            ) {
                Text(text = stringResource(id = R.string.add_review_cancel))
            }

            Text(
                text = stringResource(id = R.string.add_review_i_played) + " ...",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )

            Button(
                onClick = {
                    scope.launch {
                        reviewsViewModel.onPostReview(
                            review = ReviewPostDto(
                                id = -1,
                                title = reviewTitle,
                                reviewDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                                rate = sliderPosition.toInt() + 1,
                                reviewText = reviewText
                            ),
                            game = game
                        )
                        sheetState.hide()
                        reviewText = ""
                        reviewTitle = ""
                        sliderPosition = 0f
                    }
                }
            ) {
                Text(text = stringResource(id = R.string.add_review_save))
            }
        }

        Spacer(modifier = Modifier.height(GeneralUnits.COMPONENT_SPACER_HEIGHT))

        Row(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .padding(
                    horizontal = GeneralUnits.BASE_PADDING,
                    vertical = GeneralUnits.BASE_PADDING + GeneralUnits.BASE_PADDING
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier
                    .width(90.dp)
                    .height(127.dp)
                    .shadow(2.dp, RoundedCornerShape(8.dp), false)
            ) {
                AsyncImage(
                    model = game.coverUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
            }
            Spacer(modifier = Modifier.width(GeneralUnits.COMPONENT_SPACER_HEIGHT))
            GameDetailHeadline(text = game.title)

        }

        Spacer(modifier = Modifier.height(GeneralUnits.COMPONENT_SPACER_HEIGHT))

        Divider()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(GeneralUnits.BASE_PADDING)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = stringResource(id = R.string.add_review_rating))
                ReviewBombedRatingBar(rating = (sliderPosition + 1).toInt())
            }
            
            Slider(
                value = sliderPosition,
                onValueChange = {
                    sliderPosition = it
                },
                valueRange = 0f..4f,
                steps = 3
            )
        }
        Divider()
        Spacer(modifier = Modifier.height(GeneralUnits.COMPONENT_SPACER_HEIGHT))
        

        TextField(
            value = reviewTitle,
            onValueChange = { reviewTitle = it },
            label = { Text(text = stringResource(id = R.string.add_review_title)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(GeneralUnits.BASE_PADDING)
        )

        Spacer(modifier = Modifier.height(GeneralUnits.COMPONENT_SPACER_HEIGHT))

        TextField(
            value = reviewText,
            onValueChange = { reviewText = it },
            label = { Text(text = stringResource(id = R.string.add_review_text)) },
            modifier = Modifier
                .fillMaxWidth()
                .height(configuration.screenHeightDp.dp / 3)
                .padding(GeneralUnits.BASE_PADDING),
            maxLines = 10
        )

        Spacer(modifier = Modifier.height(GeneralUnits.COMPONENT_SPACER_HEIGHT))
    }
}