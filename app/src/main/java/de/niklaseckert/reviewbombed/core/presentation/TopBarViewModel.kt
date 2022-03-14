package de.niklaseckert.reviewbombed.core.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel

class TopBarViewModel() : ViewModel() {
    var topBarText by mutableStateOf("TEST")
    var isEnabled by mutableStateOf(true)
    var topBarPadding by mutableStateOf(0.dp)

    var isTopBarActionEnabled by mutableStateOf(false)
    var topBarActionIcon by mutableStateOf(Icons.Filled.Settings)
    var topBarActionFunction by mutableStateOf({ })
}

val TopBarState = compositionLocalOf<TopBarViewModel> { error("TopBar State Context Not Found!") }