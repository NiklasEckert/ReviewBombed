package de.niklaseckert.reviewbombed.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import de.niklaseckert.reviewbombed.R
import de.niklaseckert.reviewbombed.ui.theme.GeneralUnits

@Composable
fun ReviewBombedCustomTopBar(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.primaryVariant),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 24.sp,
            color = contentColorFor(backgroundColor = MaterialTheme.colors.primaryVariant),
            modifier = Modifier
                .padding(vertical = GeneralUnits.BASE_PADDING)
        )
    }
}