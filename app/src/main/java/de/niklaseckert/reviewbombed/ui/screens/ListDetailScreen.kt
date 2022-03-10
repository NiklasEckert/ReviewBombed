package de.niklaseckert.reviewbombed.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import de.niklaseckert.reviewbombed.R
import de.niklaseckert.reviewbombed.core.presentation.GameExcerptItem
import de.niklaseckert.reviewbombed.feature_list.presentation.ListViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListDetailScreen(
    listViewModel: ListViewModel = hiltViewModel(),
    navController: NavController
) {
    val listState = listViewModel.state.value

    Box(
        modifier = Modifier
            .padding(8.dp)
            .background(MaterialTheme.colors.background)
    ) {
        listState.listModelItem?.let { listModel ->
            Column() {
                Text(
                    text = stringResource(id = R.string.list_headline) + ": " + listModel.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp
                )
                Text(
                    text = listModel.description,
                    fontWeight = FontWeight.Light,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(8.dp))

                LazyVerticalGrid(
                    cells = GridCells.Fixed(3),
                    modifier = Modifier
                        .fillMaxSize(),
                        //.width(128.dp)
                        //.height(180.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(listModel.games.size) { index ->
                        GameExcerptItem(gameExcerpt = listModel.games[index], navController = navController)
                    }
                }
            }
        }
    }
}