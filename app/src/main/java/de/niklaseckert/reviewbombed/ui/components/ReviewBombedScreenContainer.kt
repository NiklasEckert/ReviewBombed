package de.niklaseckert.reviewbombed.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.accompanist.insets.ui.Scaffold
import de.niklaseckert.reviewbombed.core.presentation.TopBarState
import de.niklaseckert.reviewbombed.ui.ReviewBombedNavigationScreen
import de.niklaseckert.reviewbombed.ui.ReviewBombedScreen
import de.niklaseckert.reviewbombed.ui.components.general.ReviewBombedBottomNavigation
import de.niklaseckert.reviewbombed.ui.screens.*

/**
 * Composable to display the screen container.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Composable
fun ReviewBombedScreenContainer() {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()

    val topBarViewModel = TopBarState.current

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AnimatedVisibility(
                visible = topBarViewModel.isEnabled,
                enter = slideInVertically(initialOffsetY = { -it }),
                exit = slideOutVertically(targetOffsetY = { -it })
            ) {
                ReviewBombedCustomTopBar()
            }
        },
        bottomBar = {
            ReviewBombedBottomNavigation(navController = navController)
        },
    ) { innerPaddings ->
        topBarViewModel.topBarPadding = innerPaddings.calculateTopPadding()
        Box(modifier = Modifier
            .padding(
                bottom = innerPaddings.calculateBottomPadding()
            )
        ) {
            ReviewBombedNavHost(navController = navController)
        }
    }
}

@Composable
fun ReviewBombedNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ReviewBombedNavigationScreen.Home.route
    ) {
        composable(route = ReviewBombedNavigationScreen.Home.route) { HomeScreen(navController = navController) }
        composable(route = ReviewBombedNavigationScreen.Lists.route) { ListsScreen(navController = navController) }
        composable(route = ReviewBombedNavigationScreen.Reviews.route) { ReviewsScreen(navController = navController) }
        composable(route = ReviewBombedNavigationScreen.Profile.route) { ProfileDetailScreen(navController = navController) }
        composable(
            route = ReviewBombedScreen.GameDetail.route,
            arguments = listOf(navArgument("gameId") { NavType.LongType })
        ) {
            GameDetailScreen(navController = navController)
        }
        composable(
            route = ReviewBombedScreen.ListDetail.route,
            arguments = listOf(navArgument("listId") { NavType.LongType })
        ) {
            ListDetailScreen(navController = navController)
        }
        composable(
            route = ReviewBombedScreen.ReviewDetail.route,
            arguments = listOf(navArgument("reviewId") { NavType.LongType })
        ) {
            ReviewDetailsScreen(navController = navController)
        }
    }
}