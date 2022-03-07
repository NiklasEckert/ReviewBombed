package de.niklaseckert.reviewbombed.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeTab() {

    val scaffoldState = rememberScaffoldState()
    val scrollState = rememberScrollState()
    
    Scaffold(
        scaffoldState = scaffoldState
    ) {
        Box(
            modifier = Modifier.background(MaterialTheme.colors.background)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)

            ) {
                Spacer(modifier = Modifier.height(16.dp))
                CurrentlyPlayingComponent()
                Spacer(modifier = Modifier.height(16.dp))
                FriendsPlayingComponent()
                Spacer(modifier = Modifier.height(16.dp))
                FriendsFinishedComponent()
                Spacer(modifier = Modifier.height(16.dp))
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