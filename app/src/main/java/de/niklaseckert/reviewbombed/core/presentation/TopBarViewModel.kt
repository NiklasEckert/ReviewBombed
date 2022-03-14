package de.niklaseckert.reviewbombed.core.presentation

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel

/**
 * Class which represents the Top Bar.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
class TopBarViewModel() : ViewModel() {

    /** Represents the text that is displayed on the bar. */
    var topBarText by mutableStateOf("TEST")

    /** Represents if the bar is enabled. */
    var isEnabled by mutableStateOf(true)

    /** Represents the padding of the top bar. */
    var topBarPadding by mutableStateOf(0.dp)
}

/** Represents the Top Bar State. */
val TopBarState = compositionLocalOf<TopBarViewModel> { error("TopBar State Context Not Found!") }