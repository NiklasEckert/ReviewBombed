package de.niklaseckert.reviewbombed.ui.screens

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import de.niklaseckert.reviewbombed.R
import de.niklaseckert.reviewbombed.feature_login.presentation.AccountViewModel
import de.niklaseckert.reviewbombed.ui.ReviewBombedNavigationScreen
import de.niklaseckert.reviewbombed.ui.components.general.ScreenHeadline
import de.niklaseckert.reviewbombed.ui.theme.GeneralUnits

@Composable
fun LoginScreen(
    accountViewModel: AccountViewModel = hiltViewModel(),
    navController: NavController,
    localFocusManager: FocusManager = LocalFocusManager.current
) {
    var userValue by remember { mutableStateOf("") }
    var passValue by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    localFocusManager.clearFocus()
                })
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ScreenHeadline(
                text = stringResource(id = R.string.app_name)
            )

            Spacer(modifier = Modifier.height(GeneralUnits.COMPONENT_SPACER_HEIGHT))

            ScreenHeadline(text = "LOGIN")

            Spacer(modifier = Modifier.height(GeneralUnits.COMPONENT_SPACER_HEIGHT))

            TextField(
                value = userValue,
                onValueChange = { userValue = it },
                label =  { Text(text = "Username") }
            )

            Spacer(modifier = Modifier.height(GeneralUnits.COMPONENT_SPACER_HEIGHT))

            TextField(
                value = passValue,
                onValueChange = { passValue = it },
                label = { Text(text = "Password") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(GeneralUnits.COMPONENT_SPACER_HEIGHT))
            
            Button(
                onClick = {
                    accountViewModel.onGetLogin(
                        username = userValue,
                        password = passValue,
                        onSuccess = {
                            navController.navigate(ReviewBombedNavigationScreen.Home.route)
                        },
                        onError = {
                            userValue = ""
                            passValue = ""
                            localFocusManager.clearFocus()
                        }
                    )
                }
            ) {
                Text(text = "Login")
            }

        }
    }
}