package de.niklaseckert.reviewbombed.ui.components.items

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import de.niklaseckert.reviewbombed.core.domain.model.PublisherExcerpt

/**
 * Composable to display a Publisher Excerpt.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Composable
fun PublisherExcerptItem(
    publisherExcerpt: PublisherExcerpt,
    navController: NavController
) {
    Row(
       modifier = Modifier.clickable {
//           navController.navigate("developer/{devId}")
           Log.d("publisher", "Clicked  " + publisherExcerpt.name)
       }
           .fillMaxWidth()
    ) {
        Text(
            text = publisherExcerpt.name
        )
        Icon(
            imageVector = Icons.Filled.KeyboardArrowRight,
            contentDescription = null
        )
    }
}