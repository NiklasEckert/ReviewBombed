package de.niklaseckert.reviewbombed.ui

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import de.niklaseckert.reviewbombed.R

sealed class ReviewBombedScreen(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    object Home : ReviewBombedScreen("home", R.string.bottom_nav_home, Icons.Filled.Home)
    object Lists : ReviewBombedScreen("lists", R.string.bottom_nav_lists, Icons.Filled.List)
    object Reviews : ReviewBombedScreen("reviews", R.string.bottom_nav_reviews, Icons.Filled.Star)
    object Profile : ReviewBombedScreen("profile", R.string.bottom_nav_profile, Icons.Filled.Person)
}
