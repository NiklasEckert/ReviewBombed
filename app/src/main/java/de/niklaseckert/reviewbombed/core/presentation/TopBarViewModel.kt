package de.niklaseckert.reviewbombed.core.presentation

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel

class TopBarViewModel() : ViewModel() {
    var topBarText by mutableStateOf("TEST")
    var isEnabled by mutableStateOf(true)
    var topBarPadding by mutableStateOf(0.dp)
}

val TopBarState = compositionLocalOf<TopBarViewModel> { error("TopBar State Context Not Found!") }