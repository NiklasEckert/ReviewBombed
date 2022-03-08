package de.niklaseckert.reviewbombed.ui.game.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coil.compose.AsyncImage
import de.niklaseckert.reviewbombed.feature_game.domain.model.Game
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
        val (image, fab, info) = createRefs()

        AsyncImage(
            model = game.previewImageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .constrainAs(image) { top.linkTo(parent.top) }
                .height(configuration.screenHeightDp.dp / 2)
                .graphicsLayer {
                    alpha = min(1f, 1 - (rememberScrollState.value / 1500f))
                    translationY = +rememberScrollState.value * 0.7f
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
                PublisherExcerptComponent(
                    navController = navController,
                    publishers = game.publishers
                )

                Spacer(modifier = Modifier.height(16.dp))
                DeveloperExcerptComponent(
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