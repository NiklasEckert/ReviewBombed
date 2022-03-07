package de.niklaseckert.reviewbombed.ui.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import de.niklaseckert.reviewbombed.R
import de.niklaseckert.reviewbombed.feature_home.presentation.FriendsPlayingViewModel

@Composable
fun FriendsPlayingComponent(
    navController: NavController
) {
    val friendsPlayingViewModel: FriendsPlayingViewModel = hiltViewModel()
    val friendsPlayingState = friendsPlayingViewModel.state.value

    Text(
        text = stringResource(id = R.string.friends_playing_headline),
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 8.dp)
    )
    Spacer(modifier = Modifier.height(16.dp))
    GameExcerptLazyRow(gameExcerptListState = friendsPlayingState, navController = navController)

}