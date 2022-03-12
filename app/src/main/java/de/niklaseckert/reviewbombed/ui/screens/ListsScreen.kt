package de.niklaseckert.reviewbombed.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import de.niklaseckert.reviewbombed.R
import de.niklaseckert.reviewbombed.ui.components.items.ListExcerptItem
import de.niklaseckert.reviewbombed.feature_list.presentation.ListExcerptViewModel
import de.niklaseckert.reviewbombed.ui.components.ReviewBombedCustomTopBar

@Composable
fun ListsScreen(
    navController: NavController
) {
    val listExcerptViewModel: ListExcerptViewModel = hiltViewModel()
    val listExcerptState = listExcerptViewModel.state.value

    Scaffold(
        topBar = {
            ReviewBombedCustomTopBar(text = stringResource(id = R.string.bottom_nav_lists))
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            LazyColumn() {
                items(listExcerptState.listExcerptItems.size) { index ->
                    val listExcerpt = listExcerptState.listExcerptItems[index]

                    ListExcerptItem(listExcerpt = listExcerpt, navController = navController)
                }
            }
        }
    }

}