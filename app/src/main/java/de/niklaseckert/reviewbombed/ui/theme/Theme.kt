package de.niklaseckert.reviewbombed.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

/**
 * File which represents the color mapping.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
private val DarkColorPalette = darkColors(
    primary = Orange400,
    primaryVariant = BlueGray900,
    secondary = Orange400,
    background = BlueGray800,
    surface = BlueGray600
)

//private val LightColorPalette = lightColors(
//    primary = Purple500,
//    primaryVariant = Purple700,
//    secondary = Teal200
//)

/**
 * Composable to set the app always in dark mode.
 */
@Composable
fun ReviewBombedTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
//        LightColorPalette
        DarkColorPalette
    }

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = BlueGray900
    )
    systemUiController.setNavigationBarColor(
        color = Black
    )

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}