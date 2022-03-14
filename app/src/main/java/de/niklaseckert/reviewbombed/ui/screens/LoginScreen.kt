package de.niklaseckert.reviewbombed.ui.screens

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import de.niklaseckert.reviewbombed.R
import de.niklaseckert.reviewbombed.feature_login.presentation.AccountState
import de.niklaseckert.reviewbombed.ui.components.general.ScreenHeadline
import de.niklaseckert.reviewbombed.ui.theme.GeneralUnits
import kotlinx.coroutines.launch

/**
 * Composable to display the login screen.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Composable
fun LoginScreen(
    localFocusManager: FocusManager = LocalFocusManager.current
) {
    var userValue by remember { mutableStateOf("") }
    var passValue by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()
    val vm = AccountState.current

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
            if (vm.isBusy) {
                CircularProgressIndicator()
            } else {
                ScreenHeadline(
                    text = stringResource(id = R.string.app_name)
                )

                Spacer(modifier = Modifier.height(GeneralUnits.COMPONENT_SPACER_HEIGHT))

                ScreenHeadline(text = "LOGIN")

                Spacer(modifier = Modifier.height(GeneralUnits.COMPONENT_SPACER_HEIGHT))

                TextField(
                    value = userValue,
                    onValueChange = { userValue = it },
                    label =  { Text(text = stringResource(id = R.string.login_username)) }
                )

                Spacer(modifier = Modifier.height(GeneralUnits.COMPONENT_SPACER_HEIGHT))

                TextField(
                    value = passValue,
                    onValueChange = { passValue = it },
                    label = { Text(text = stringResource(id = R.string.login_password)) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = PasswordVisualTransformation()
                )

                Spacer(modifier = Modifier.height(GeneralUnits.COMPONENT_SPACER_HEIGHT))

                Button(
                    onClick = {
                        coroutineScope.launch {
                            vm.signInFun(userValue, passValue)
                        }
                    }
                ) {
                    Text(text = "Login")
                }
            }



        }
    }
}