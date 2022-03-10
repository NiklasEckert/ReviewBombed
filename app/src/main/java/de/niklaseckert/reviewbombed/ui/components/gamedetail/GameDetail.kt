package de.niklaseckert.reviewbombed.ui.components.gamedetail

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coil.compose.AsyncImage
import de.niklaseckert.reviewbombed.feature_game.domain.model.Game
import de.niklaseckert.reviewbombed.ui.components.developerexcerpts.DeveloperExcerptListComponent
import de.niklaseckert.reviewbombed.ui.components.publisherexcerpts.PublisherExcerptListComponent
import de.niklaseckert.reviewbombed.ui.components.screenshots.ScreenshotExcerptListComponent
import java.time.format.DateTimeFormatter
import kotlin.math.min

@Composable
fun GameDetail(
    game: Game,
    rememberScrollState: ScrollState,
    navController: NavController
) {
    val configuration = LocalConfiguration.current

    ConstraintLayout() {
        val (image, sp, fab, info) = createRefs()

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

        Column(
            modifier = Modifier
                .background(Color.White)
                .constrainAs(info) {
                    top.linkTo(image.bottom)
                }
        ) {
            Column(
                modifier = Modifier.padding(all = 8.dp)
            ) {
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = game.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp,
                    modifier = Modifier
                        .wrapContentWidth(Alignment.Start)
                )

                Text(
                    text = game.date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                    fontWeight = FontWeight.Light,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = game.description
                )

                Spacer(modifier = Modifier.height(16.dp))
                Divider()
                ScreenshotExcerptListComponent(
                    screenshots = game.screenshots,
                    navController = navController
                )

                Spacer(modifier = Modifier.height(16.dp))
                Divider()
                PublisherExcerptListComponent(
                    navController = navController,
                    publishers = game.publishers
                )

                Spacer(modifier = Modifier.height(16.dp))
                DeveloperExcerptListComponent(
                    navController = navController,
                    developers = game.developers
                )
            }

        }

        FloatingActionButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .constrainAs(fab) {
                    centerAround(image.bottom)
                    absoluteRight.linkTo(parent.absoluteRight, margin = 16.dp)
                }
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = null,
                tint = Color.White
            )
        }

    }
}