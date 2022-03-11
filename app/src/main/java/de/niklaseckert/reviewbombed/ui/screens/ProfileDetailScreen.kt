package de.niklaseckert.reviewbombed.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import de.niklaseckert.reviewbombed.R
import de.niklaseckert.reviewbombed.ui.components.ReviewBombedCustomTopBar

@Composable
fun ProfileDetailScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            ReviewBombedCustomTopBar(text = stringResource(id = R.string.bottom_nav_profile))
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = "Profile")
        }
    }
    
    

}