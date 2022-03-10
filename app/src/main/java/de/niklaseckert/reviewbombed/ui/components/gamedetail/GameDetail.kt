package de.niklaseckert.reviewbombed.ui.components.gamedetail

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import de.niklaseckert.reviewbombed.feature_game.domain.model.Game
import de.niklaseckert.reviewbombed.ui.components.developerexcerpts.DeveloperExcerptListComponent
import de.niklaseckert.reviewbombed.ui.components.general.GameDetailHeadline
import de.niklaseckert.reviewbombed.ui.components.general.LocalDateText
import de.niklaseckert.reviewbombed.ui.components.publisherexcerpts.PublisherExcerptListComponent
import de.niklaseckert.reviewbombed.ui.components.screenshots.ScreenshotExcerptListComponent
import de.niklaseckert.reviewbombed.ui.theme.GeneralUnits
import kotlin.math.min

@Composable
fun GameDetail(
    game: Game,
    rememberScrollState: ScrollState,
    navController: NavController
) {
    val configuration = LocalConfiguration.current

    ConstraintLayout {
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
                .background(Color.White)
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
                .background(Color.White)
                .constrainAs(comps) {
                    top.linkTo(info.bottom)
                }
        ) {
            Column(
                modifier = Modifier.padding(GeneralUnits.BASE_PADDING)
            ) {
                Spacer(modifier = Modifier.height(GeneralUnits.COMPONENT_SPACER_HEIGHT))
                Divider()
                ScreenshotExcerptListComponent(
                    screenshots = game.screenshots,
                    navController = navController
                )

                Spacer(modifier = Modifier.height(GeneralUnits.COMPONENT_SPACER_HEIGHT))
                Divider()
                PublisherExcerptListComponent(
                    navController = navController,
                    publishers = game.publishers
                )

                Spacer(modifier = Modifier.height(GeneralUnits.COMPONENT_SPACER_HEIGHT))
                DeveloperExcerptListComponent(
                    navController = navController,
                    developers = game.developers
                )
            }

        }

        GameDetailFloatingActionButton(
            modifier = Modifier
                .constrainAs(fab) {
                    centerAround(image.bottom)
                    absoluteRight.linkTo(parent.absoluteRight, margin = 16.dp)
                }
        )
    }
}