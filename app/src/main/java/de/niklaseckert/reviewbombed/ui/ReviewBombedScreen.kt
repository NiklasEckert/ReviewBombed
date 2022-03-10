package de.niklaseckert.reviewbombed.ui

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import de.niklaseckert.reviewbombed.R

sealed class ReviewBombedNavigationScreen(override val route: String, @StringRes val resourceId: Int, val icon: ImageVector) : ReviewBombedScreen(route = route) {
    object Home     : ReviewBombedNavigationScreen(route = "home", R.string.bottom_nav_home, Icons.Filled.Home)
    object Lists    : ReviewBombedNavigationScreen(route = "lists", R.string.bottom_nav_lists, Icons.Filled.List)
    object Reviews  : ReviewBombedNavigationScreen(route = "reviews", R.string.bottom_nav_reviews, Icons.Filled.Star)
    object Profile  : ReviewBombedNavigationScreen(route = "profile", R.string.bottom_nav_profile, Icons.Filled.Person)
}

sealed class ReviewBombedScreen(open val route: String) {
    object GameDetail       : ReviewBombedScreen(route = "game/{gameId}")
    object ListDetail       : ReviewBombedScreen(route = "list/{listId}")
    object ReviewDetail     : ReviewBombedScreen(route = "review/{reviewId}")
    object ProfileDetail    : ReviewBombedScreen(route = "profile/{profileId}")
}


