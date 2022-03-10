package de.niklaseckert.reviewbombed.ui.components.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import de.niklaseckert.reviewbombed.core.domain.model.ListExcerpt
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ListExcerptItem(
    listExcerpt: ListExcerpt,
    modifier: Modifier = Modifier,
    navController: NavController
) {

        Column(
            modifier = modifier
                .clickable { navController.navigate("list/" + listExcerpt.id) }
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = listExcerpt.name,
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp
            )
            Text(
                text = listExcerpt.description,
                fontWeight = FontWeight.Light,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Divider()
        }
}