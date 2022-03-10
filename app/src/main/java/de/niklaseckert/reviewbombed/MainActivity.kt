package de.niklaseckert.reviewbombed

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import de.niklaseckert.reviewbombed.ui.ReviewBombedScreen
import de.niklaseckert.reviewbombed.ui.lists.ListsScreen
import de.niklaseckert.reviewbombed.ui.screens.ReviewDetailsScreen
import de.niklaseckert.reviewbombed.ui.reviews.ReviewsTab
import de.niklaseckert.reviewbombed.ui.screens.GameDetailScreen
import de.niklaseckert.reviewbombed.ui.screens.HomeScreen
import de.niklaseckert.reviewbombed.ui.screens.ListDetailScreen
import de.niklaseckert.reviewbombed.ui.screens.ProfileDetailScreen
import de.niklaseckert.reviewbombed.ui.theme.ReviewBombedTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReviewBombedTheme {

                val navController = rememberNavController()
                val items = listOf(
                    ReviewBombedScreen.Home,
                    ReviewBombedScreen.Lists,
                    ReviewBombedScreen.Reviews,
                    ReviewBombedScreen.Profile
                )

                Scaffold(
                    bottomBar = {

                        BottomNavigation {
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentDestination = navBackStackEntry?.destination

                            items.forEach { screen ->
                                BottomNavigationItem(
                                    icon = {
                                        Icon(
                                            imageVector = screen.icon,
                                            contentDescription = null
                                        )
                                    },
                                    label = { Text(text = stringResource(id = screen.resourceId)) },
                                    selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                                    onClick = {
                                        navController.navigate(screen.route) {
                                            popUpTo(navController.graph.findStartDestination().id) {
                                                saveState = true
                                            }

                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    }
                                )
                            }
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = ReviewBombedScreen.Home.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("home") { HomeScreen(navController = navController) }
                        composable("lists") { ListsScreen(navController = navController) }
                        composable("reviews") { ReviewsTab(navController = navController) }
                        composable("profile") { ProfileDetailScreen() }
                        composable(
                            route = "game/{gameId}",
                            arguments = listOf(navArgument("gameId") { NavType.LongType })
                        ) {
                            GameDetailScreen(navController = navController)
                        }
                        composable(
                            route = "list/{listId}",
                            arguments = listOf(navArgument("listId") { NavType.LongType })
                        ) {
                            ListDetailScreen(navController = navController)
                        }
                        composable(
                            route = "review/{reviewId}",
                            arguments = listOf(navArgument("reviewId") { NavType.LongType })
                        ) {
                            ReviewDetailsScreen(navController = navController)
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