package de.niklaseckert.reviewbombed.ui.components.general

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

/**
 * Composables for all headlines used in this app.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */

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
    modifier: Modifier = Modifier,
    fontWeight: FontWeight? = FontWeight.Bold,
) {
    Text(
        text = text,
        fontWeight = fontWeight,
        fontSize = fontSize,
        modifier = modifier
    )
}