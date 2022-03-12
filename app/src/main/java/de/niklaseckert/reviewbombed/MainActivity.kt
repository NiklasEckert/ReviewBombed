package de.niklaseckert.reviewbombed

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import de.niklaseckert.reviewbombed.feature_login.presentation.AccountViewModel
import de.niklaseckert.reviewbombed.ui.ReviewBombedNavigationScreen
import de.niklaseckert.reviewbombed.ui.ReviewBombedScreen
import de.niklaseckert.reviewbombed.ui.screens.ListsScreen
import de.niklaseckert.reviewbombed.ui.screens.*
import de.niklaseckert.reviewbombed.ui.theme.ReviewBombedTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReviewBombedTheme {
                val navController = rememberNavController()

                val accountViewModel: AccountViewModel = hiltViewModel()
                val loginState = accountViewModel.state.value

                Scaffold(
//                    topBar = {
//                        ReviewBombedCustomTopBar()
//                    },
//                    bottomBar = {
//
//                    }
                ) { innerPadding ->

                    var startRoute = if (!loginState.isLoading && loginState.userItem != null) {
                        ReviewBombedNavigationScreen.Home.route
                    } else {
                        ReviewBombedScreen.LoginScreen.route
                    }

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
                            LoginScreen(navController = navController)
                        }
                    }

                    if (loginState.isLoading) {
                        Log.d("main", "is loading")
                    } else {
                        Log.d("main", "test: " + loginState.userItem?.username)
                        if (loginState.userItem == null) {
                            navController.navigate(ReviewBombedScreen.LoginScreen.route)
                        }
                    }
                }
            }
        }
    }

    @Preview
    @Composable
    fun Preview() {
        onCreate(null)
    }
}