package de.niklaseckert.reviewbombed.feature_developer.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import de.niklaseckert.reviewbombed.feature_developer.domain.model.Developer

@Composable
fun DeveloperItem(
    developer: Developer,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = "ID: ${developer.id}"
        )
        Text(
            text = developer.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}