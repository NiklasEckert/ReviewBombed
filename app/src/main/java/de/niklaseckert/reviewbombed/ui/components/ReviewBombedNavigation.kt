package de.niklaseckert.reviewbombed.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import de.niklaseckert.reviewbombed.ui.ReviewBombedNavigationScreen
import de.niklaseckert.reviewbombed.ui.ReviewBombedScreen
import de.niklaseckert.reviewbombed.ui.screens.*

@Composable
fun ReviewBombedNavigation() {
    val navController = rememberNavController()

//                val accountViewModel: AccountViewModel = hiltViewModel()
//                val loginState = accountViewModel.state.value
//                val isLoggedInState = accountViewModel.isLoggedInState.value

    Scaffold() { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = ReviewBombedNavigationScreen.Home.route,
            modifier = Modifier.padding(innerPadding)
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
            composable(
                route = ReviewBombedScreen.LoginScreen.route
            ) {
//                LoginScreen(navController = navController)
            }
        }
    }
}