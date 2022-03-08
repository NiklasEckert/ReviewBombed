package de.niklaseckert.reviewbombed

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import de.niklaseckert.reviewbombed.ui.game.GameTab
import de.niklaseckert.reviewbombed.ui.home.*
import de.niklaseckert.reviewbombed.ui.lists.ListsTab
import de.niklaseckert.reviewbombed.ui.profile.ProfileTab
import de.niklaseckert.reviewbombed.ui.reviews.ReviewsTab
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
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = { /*TODO*/ },
                            shape = RoundedCornerShape(50),
                            backgroundColor = Color.Black
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Add,
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    },
                    isFloatingActionButtonDocked = true,
                    floatingActionButtonPosition = FabPosition.Center,

                    bottomBar = {
                        BottomAppBar(
                            cutoutShape = RoundedCornerShape(percent = 50),
                            content = {
                                BottomNavigation {
                                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                                    val currentDestination = navBackStackEntry?.destination

                                    items.forEachIndexed{ index, screen ->
                                        BottomNavigationItem(
                                            icon = { Icon(imageVector = screen.icon, contentDescription = null) },
                                            label = {
                                                Text(
                                                    text = stringResource(id = screen.resourceId),
                                                    softWrap = false
                                                )
                                            },
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
                                        if (index == 1) {
                                            Spacer(modifier = Modifier.weight(.5f))
                                        }
                                    }
                                }
                            }
                        )
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = ReviewBombedScreen.Home.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("home") { HomeTab(navController = navController) }
                        composable("lists") { ListsTab() }
                        composable("reviews") { ReviewsTab() }
                        composable("profile") { ProfileTab() }
                        composable(
                            route = "game/{gameId}",
                            arguments = listOf(navArgument("gameId") { NavType.LongType })
                        ) {
                            GameTab(navController = navController)
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