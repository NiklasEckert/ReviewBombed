package de.niklaseckert.reviewbombed.ui.components.general

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * Composable which displays a Local Date.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Composable
fun LocalDateText(
    date: LocalDate,
    modifier: Modifier = Modifier
) {
    Text(
        text = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
        fontWeight = FontWeight.Light,
        fontSize = 16.sp,
        modifier = modifier
    )
}