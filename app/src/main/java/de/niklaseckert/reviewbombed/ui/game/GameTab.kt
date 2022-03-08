package de.niklaseckert.reviewbombed.ui.game

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import de.niklaseckert.reviewbombed.feature_game.presentation.GameViewModel
import de.niklaseckert.reviewbombed.ui.game.components.DeveloperExcerptComponent
import de.niklaseckert.reviewbombed.ui.game.components.PublisherExcerptComponent
import java.time.format.DateTimeFormatter
import kotlin.math.min

@Composable
fun GameTab(
    gameViewModel: GameViewModel = hiltViewModel(),
    navController: NavController
) {
    val gameState = gameViewModel.state.value

    val configuration = LocalConfiguration.current

    val rememberScrollState = rememberScrollState()

    Box(
        modifier = Modifier.background(MaterialTheme.colors.background)
    ) {
        gameState.gameItem?.let { game ->
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState)
            ) {
                AsyncImage(
                    model = game.coverUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(configuration.screenHeightDp.dp / 2)
                        .graphicsLayer {
                            alpha = min(1f, 1 - (rememberScrollState.value / 1500f))
                            translationY = +rememberScrollState.value * 0.7f
                        }
                )
                Column(
                    modifier = Modifier
                        .background(Color.White)
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
                        PublisherExcerptComponent(navController = navController, publishers = game.publishers)

                        Spacer(modifier = Modifier.height(16.dp))
                        DeveloperExcerptComponent(navController = navController, developers = game.developers)
                        
                    }

                }
            }
        }
    }
}