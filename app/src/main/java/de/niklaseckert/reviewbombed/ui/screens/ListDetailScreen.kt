package de.niklaseckert.reviewbombed.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import de.niklaseckert.reviewbombed.core.presentation.TopBarState
import de.niklaseckert.reviewbombed.ui.components.items.GameExcerptItem
import de.niklaseckert.reviewbombed.feature_list.presentation.ListViewModel
import de.niklaseckert.reviewbombed.ui.theme.GeneralUnits

/**
 * Composable to display the details of a List.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListDetailScreen(
    listViewModel: ListViewModel = hiltViewModel(),
    navController: NavController
) {
    val listState = listViewModel.state.value

    val topBarViewModel = TopBarState.current
    topBarViewModel.isEnabled = true
    topBarViewModel.isTopBarActionEnabled = false

    Column(
        modifier = Modifier
            .padding(top = topBarViewModel.topBarPadding)
    ) {
        listState.listModelItem?.let { listModel ->
            Column(
                modifier = Modifier
                    .padding(GeneralUnits.BASE_PADDING)
            ) {
                Text(
                    text = listModel.name,
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