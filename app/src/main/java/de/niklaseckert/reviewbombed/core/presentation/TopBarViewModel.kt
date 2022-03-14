package de.niklaseckert.reviewbombed.core.presentation

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TopBarViewModel() : ViewModel() {
    var topBarText by mutableStateOf("TEST")
}

val TopBarState = compositionLocalOf<TopBarViewModel> { error("TopBar State Context Not Found!") }