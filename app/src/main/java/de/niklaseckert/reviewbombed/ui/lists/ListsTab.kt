package de.niklaseckert.reviewbombed.ui.lists

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import de.niklaseckert.reviewbombed.core.presentation.ListExcerptItem
import de.niklaseckert.reviewbombed.feature_list.presentation.ListExcerptViewModel

@Composable
fun ListsTab(
    navController: NavController
) {
    val listExcerptViewModel: ListExcerptViewModel = hiltViewModel()
    val listExcerptState = listExcerptViewModel.state.value

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState
    ) {
        Box(
            modifier = Modifier.background(MaterialTheme.colors.background)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
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
}