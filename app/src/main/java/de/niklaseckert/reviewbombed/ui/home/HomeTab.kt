package de.niklaseckert.reviewbombed.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import de.niklaseckert.reviewbombed.ui.components.home.CurrentlyPlayingComponent
import de.niklaseckert.reviewbombed.ui.components.home.FriendsFinishedComponent
import de.niklaseckert.reviewbombed.ui.components.home.FriendsPlayingComponent

@Composable
fun HomeTab(
    navController: NavController
) {

    val scaffoldState = rememberScaffoldState()
    val scrollState = rememberScrollState()
    
    Scaffold(
        scaffoldState = scaffoldState
    ) {
        Box(
            modifier = Modifier.background(MaterialTheme.colors.background)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)

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
    }
}