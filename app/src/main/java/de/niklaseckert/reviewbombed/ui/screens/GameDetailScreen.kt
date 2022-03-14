package de.niklaseckert.reviewbombed.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import de.niklaseckert.reviewbombed.core.presentation.TopBarState
import de.niklaseckert.reviewbombed.feature_game.presentation.GameViewModel
import de.niklaseckert.reviewbombed.feature_review.presentation.ReviewViewModel
import de.niklaseckert.reviewbombed.ui.components.developerexcerpts.DeveloperExcerptListComponent
import de.niklaseckert.reviewbombed.ui.components.gamedetail.AddReviewSheet
import de.niklaseckert.reviewbombed.ui.components.gamedetail.GameDetailFloatingActionButton
import de.niklaseckert.reviewbombed.ui.components.gamedetail.GameDetailPreviewImage
import de.niklaseckert.reviewbombed.ui.components.general.GameDetailHeadline
import de.niklaseckert.reviewbombed.ui.components.general.LocalDateText
import de.niklaseckert.reviewbombed.ui.components.publisherexcerpts.PublisherExcerptListComponent
import de.niklaseckert.reviewbombed.ui.components.screenshots.ScreenshotExcerptListComponent
import de.niklaseckert.reviewbombed.ui.theme.GeneralUnits
import kotlinx.coroutines.launch
import kotlin.math.min

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GameDetailScreen(
    gameViewModel: GameViewModel = hiltViewModel(),
    navController: NavController
) {
    val gameState = gameViewModel.state.value
    val rememberScrollState = rememberScrollState()
    val configuration = LocalConfiguration.current

    var skipHalfExpanded by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = skipHalfExpanded
    )

    val topBarViewModel = TopBarState.current
    topBarViewModel.isEnabled = false
    topBarViewModel.isTopBarActionEnabled = false

    gameState.gameItem?.let { game ->

        ModalBottomSheetLayout(
            sheetState = sheetState,
            sheetContent = {
                AddReviewSheet(game, sheetState = sheetState)
            },
            sheetElevation = 26.dp
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .verticalScroll(rememberScrollState)
            ) {
                val (image, sp, fab, info, comps) = createRefs()

                GameDetailPreviewImage(
                    url = game.previewImageUrl,
                    imageModifier = Modifier
                        .constrainAs(image) { top.linkTo(parent.top) }
                        .height(configuration.screenHeightDp.dp / 2)
                        .graphicsLayer {
                            alpha = min(1f, 1 - (rememberScrollState.value / 1500f))
                            translationY = +rememberScrollState.value * 0.7f
                        },
                    spacerModifier = Modifier
                        .constrainAs(sp) {
                            bottom.linkTo(image.bottom)
                        }
                )

                Box(
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .constrainAs(info) {
                            top.linkTo(image.bottom)
                        }
                ) {
                    Column(
                        modifier = Modifier.padding(GeneralUnits.BASE_PADDING)
                    ) {
                        GameDetailHeadline(text = game.title)
                        LocalDateText(date = game.date)
                        Text(
                            text = game.description
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .constrainAs(comps) {
                            top.linkTo(info.bottom)
                        }
                ) {
                    Column() {
                        Spacer(modifier = Modifier.height(GeneralUnits.COMPONENT_SPACER_HEIGHT))
                        Divider(modifier = Modifier.padding(GeneralUnits.BASE_PADDING))
                        ScreenshotExcerptListComponent(
                            screenshots = game.screenshots,
                            navController = navController
                        )

                        Spacer(modifier = Modifier.height(GeneralUnits.COMPONENT_SPACER_HEIGHT))
                        Divider(modifier = Modifier.padding(GeneralUnits.BASE_PADDING))
                        PublisherExcerptListComponent(
                            navController = navController,
                            publishers = game.publishers,
                            modifier = Modifier.padding(GeneralUnits.BASE_PADDING)
                        )

                        Spacer(modifier = Modifier.height(GeneralUnits.COMPONENT_SPACER_HEIGHT))
                        DeveloperExcerptListComponent(
                            navController = navController,
                            developers = game.developers,
                            modifier = Modifier.padding(GeneralUnits.BASE_PADDING)
                        )
                    }

                }

                GameDetailFloatingActionButton(
                    modifier = Modifier
                        .constrainAs(fab) {
                            centerAround(image.bottom)
                            absoluteRight.linkTo(parent.absoluteRight, margin = 16.dp)
                        },
                    onClick = {
                        scope.launch {
                            sheetState.animateTo(ModalBottomSheetValue.Expanded)
                        }
                    }
                )
            }
        }
    }
}