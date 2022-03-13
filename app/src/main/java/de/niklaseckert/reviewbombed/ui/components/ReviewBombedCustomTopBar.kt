package de.niklaseckert.reviewbombed.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.niklaseckert.reviewbombed.R
import de.niklaseckert.reviewbombed.feature_login.presentation.AccountState
import de.niklaseckert.reviewbombed.ui.theme.GeneralUnits
import kotlinx.coroutines.launch

@Composable
fun ReviewBombedCustomTopBar(
    modifier: Modifier = Modifier,
    text: String = stringResource(id = R.string.app_name)
) {
    val vm = AccountState.current
    val coroutineScope = rememberCoroutineScope()

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.primaryVariant)
            .padding(vertical = GeneralUnits.BASE_PADDING),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(
            modifier = Modifier
                .size(24.dp)
        ) {

        }

        Column() {
            Text(
                text = text,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp,
                modifier = Modifier
                    .background(MaterialTheme.colors.primaryVariant)
            )
        }

        Column(
            modifier = Modifier
                .size(24.dp)
        ) {
            IconButton(
                onClick = {
                    coroutineScope.launch {
                        vm.signOutFun()
                    }
                }
            ) {
                Icon(Icons.Filled.ExitToApp, null)
            }
        }


    }
}