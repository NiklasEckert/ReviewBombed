package de.niklaseckert.reviewbombed.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import de.niklaseckert.reviewbombed.R
import de.niklaseckert.reviewbombed.core.presentation.TopBarState
import de.niklaseckert.reviewbombed.core.presentation.TopBarViewModel
import de.niklaseckert.reviewbombed.ui.components.ReviewBombedCustomTopBar
import de.niklaseckert.reviewbombed.ui.components.general.ReviewBombedBottomNavigation
import de.niklaseckert.reviewbombed.ui.components.home.CurrentlyPlayingComponent
import de.niklaseckert.reviewbombed.ui.components.home.FriendsFinishedComponent
import de.niklaseckert.reviewbombed.ui.components.home.FriendsPlayingComponent

@Composable
fun HomeScreen(
    navController: NavController
) {
    val scrollState = rememberScrollState()
    val topBarViewModel = TopBarState.current
    topBarViewModel.topBarText = stringResource(id = R.string.app_name)
    topBarViewModel.isEnabled = true
    topBarViewModel.isTopBarActionEnabled = false

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(top = topBarViewModel.topBarPadding)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        CurrentlyPlayingComponent(navController = navController)
        Spacer(modifier = Modifier.height(16.dp))
        FriendsPlayingComponent(navController = navController)
        Spacer(modifier = Modifier.height(16.dp))
        FriendsFinishedComponent(navController = navController)
        Spacer(modifier = Modifier.height(16.dp))
    }
}