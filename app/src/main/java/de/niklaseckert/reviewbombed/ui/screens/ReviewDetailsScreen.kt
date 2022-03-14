package de.niklaseckert.reviewbombed.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import de.niklaseckert.reviewbombed.core.presentation.TopBarState
import de.niklaseckert.reviewbombed.feature_login.data.local.SaveAccount
import de.niklaseckert.reviewbombed.feature_login.presentation.AccountState
import de.niklaseckert.reviewbombed.ui.components.items.GameExcerptItem
import de.niklaseckert.reviewbombed.feature_review.presentation.ReviewViewModel
import de.niklaseckert.reviewbombed.ui.components.ReviewBombedRatingBar
import de.niklaseckert.reviewbombed.ui.components.gamedetail.AddReviewSheet
import de.niklaseckert.reviewbombed.ui.components.gamedetail.EditReviewSheet
import de.niklaseckert.reviewbombed.ui.theme.GeneralUnits
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ReviewDetailsScreen(
    reviewViewModel: ReviewViewModel = hiltViewModel(),
    navController: NavController
) {
    val accountViewModel = AccountState.current

    val reviewState = reviewViewModel.state.value

    var skipHalfExpanded by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = skipHalfExpanded
    )

    val topBarViewModel = TopBarState.current
    topBarViewModel.isEnabled = true
//    topBarViewModel.isTopBarActionEnabled = true
    topBarViewModel.topBarActionIcon = Icons.Outlined.MoreVert
    topBarViewModel.topBarActionFunction = {
        scope.launch {
            sheetState.animateTo(ModalBottomSheetValue.Expanded)
        }
    }

    reviewState.reviewItem?.let { review ->
        ModalBottomSheetLayout(
            sheetState = sheetState,
            sheetContent = {
                EditReviewSheet(
                    review = review,
                    sheetState = sheetState,
                    modifier = Modifier.padding(top = topBarViewModel.topBarPadding),
                    onSave = {
                        reviewViewModel.onGetReview(reviewId = review.id)
                    }
                )
            },
            sheetElevation = 26.dp
        ) {
            runBlocking {
                topBarViewModel.isTopBarActionEnabled = accountViewModel.saveAccount.getAccountId() == (review.user.id)
            }

            Column(
                modifier = Modifier
                    .padding(
                        top = topBarViewModel.topBarPadding + GeneralUnits.BASE_PADDING,
                        start = GeneralUnits.BASE_PADDING,
                        end = GeneralUnits.BASE_PADDING,
                        bottom = GeneralUnits.BASE_PADDING
                    )
            ) {
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
}