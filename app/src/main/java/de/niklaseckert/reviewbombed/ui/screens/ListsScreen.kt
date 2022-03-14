package de.niklaseckert.reviewbombed.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import de.niklaseckert.reviewbombed.R
import de.niklaseckert.reviewbombed.core.presentation.TopBarState
import de.niklaseckert.reviewbombed.ui.components.items.ListExcerptItem
import de.niklaseckert.reviewbombed.feature_list.presentation.ListExcerptViewModel
import de.niklaseckert.reviewbombed.ui.theme.GeneralUnits

/**
 * Composable to display all Lists.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Composable
fun ListsScreen(
    navController: NavController
) {
    val listExcerptViewModel: ListExcerptViewModel = hiltViewModel()
    val listExcerptState = listExcerptViewModel.state.value

    val topBarViewModel = TopBarState.current
    topBarViewModel.topBarText = stringResource(id = R.string.bottom_nav_lists)
    topBarViewModel.isEnabled = true

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = topBarViewModel.topBarPadding)
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(GeneralUnits.BASE_PADDING)
        ) {
            items(listExcerptState.listExcerptItems.size) { index ->
                val listExcerpt = listExcerptState.listExcerptItems[index]

                ListExcerptItem(listExcerpt = listExcerpt, navController = navController)
            }
        }
    }
}