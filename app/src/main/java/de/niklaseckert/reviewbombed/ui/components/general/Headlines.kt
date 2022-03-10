package de.niklaseckert.reviewbombed.ui.components.general

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun GameDetailHeadline(
    text: String,
    modifier: Modifier = Modifier
) {
    Headline(
        text = text,
        fontSize = 24.sp,
        modifier = modifier
    )
}

@Composable
fun ScreenHeadline(
    text: String,
    modifier: Modifier = Modifier
) {
    Headline(
        text = text,
        fontSize = 32.sp,
        modifier = modifier
    )
}

@Composable
fun Headline(
    text: String,
    fontSize: TextUnit,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        fontSize = fontSize,
        modifier = modifier
    )
}