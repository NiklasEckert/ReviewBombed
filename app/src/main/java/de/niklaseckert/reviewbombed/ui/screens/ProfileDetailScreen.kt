package de.niklaseckert.reviewbombed.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import de.niklaseckert.reviewbombed.R
import de.niklaseckert.reviewbombed.feature_profile.presentation.ProfileViewModel
import de.niklaseckert.reviewbombed.ui.components.ReviewBombedCustomTopBar
import de.niklaseckert.reviewbombed.ui.components.profile.ListsOfUserComponent
import de.niklaseckert.reviewbombed.ui.components.profile.ReviewsOfUserComponent
import de.niklaseckert.reviewbombed.ui.theme.GeneralUnits

@Composable
fun ProfileDetailScreen(
    navController: NavController
) {

    val profileViewModel: ProfileViewModel = hiltViewModel()
    val profileState = profileViewModel.state.value
    val scaffoldState = rememberScaffoldState()
    val scrollState = rememberScrollState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            ReviewBombedCustomTopBar(text = stringResource(id = R.string.bottom_nav_profile))
        }
    ) {
        Column(
            modifier = Modifier
                //.fillMaxSize()
                .padding(GeneralUnits.BASE_PADDING)
                .verticalScroll(scrollState)
        ) {
            profileState.profileItem?.let { profile ->

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        AsyncImage(
                            model = profile.profileImageUrl,
                            contentDescription = null,
                            modifier = Modifier
                                .size(128.dp)
                                .border(
                                    shape = RoundedCornerShape(percent = 50),
                                    width = 1.dp,
                                    color = Color.Transparent
                                )
                        )

                        Text(text = profile.name)
                    }
                }

                Spacer(modifier = Modifier.height(GeneralUnits.COMPONENT_SPACER_HEIGHT))
                Divider()

                ReviewsOfUserComponent(navController = navController, reviews = profile.reviews)

                Spacer(modifier = Modifier.height(GeneralUnits.COMPONENT_SPACER_HEIGHT))
                Divider()

                ListsOfUserComponent(navController = navController, lists = profile.listExcerpts)
            }
        }
    }
    
    

}