package de.niklaseckert.reviewbombed.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import de.niklaseckert.reviewbombed.R
import de.niklaseckert.reviewbombed.core.presentation.GameExcerptItem
import de.niklaseckert.reviewbombed.feature_developer.presentation.DeveloperItem
import de.niklaseckert.reviewbombed.feature_developer.presentation.DeveloperViewModel
import de.niklaseckert.reviewbombed.feature_home.presentation.CurrentlyPlayingViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun HomeTab() {
    val currentlyPlayingViewModel: CurrentlyPlayingViewModel = hiltViewModel()
    val currentlyPlayingState = currentlyPlayingViewModel.state.value
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
                Text(
                    text = stringResource(id = R.string.currently_playing_headline),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(16.dp))
                CurrentlyPlayingList(currentlyPlayingState = currentlyPlayingState)
            }
        }
    }

/*val viewModel: DeveloperViewModel = hiltViewModel()
    val state = viewModel.state.value
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when(event) {
                is DeveloperViewModel.UIEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
            }
        }
    }

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
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(state.developerItems.size) { index ->
                        val developer = state.developerItems[index]
                        if (index > 0) {
                            Spacer(modifier = Modifier.height(8.dp))
                        }

                        DeveloperItem(developer = developer)

                        if (index < state.developerItems.size -1) {
                            Divider()
                        }
                    }
                }
            }
        }
    }*/
}