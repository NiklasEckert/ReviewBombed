package de.niklaseckert.reviewbombed.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import de.niklaseckert.reviewbombed.R
import de.niklaseckert.reviewbombed.core.presentation.TopBarState
import de.niklaseckert.reviewbombed.core.presentation.TopBarViewModel
import de.niklaseckert.reviewbombed.feature_login.presentation.AccountState
import de.niklaseckert.reviewbombed.ui.theme.GeneralUnits
import kotlinx.coroutines.launch

/**
 * Composable to display the top bar.
 *
 * @author Niklas Eckert
 * @author Jakob Friedsam
 */
@Composable
fun ReviewBombedCustomTopBar(
    modifier: Modifier = Modifier
) {
    val vm = AccountState.current
    val coroutineScope = rememberCoroutineScope()
    val topBarViewModel = TopBarState.current

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.primaryVariant)
            .padding(vertical = GeneralUnits.BASE_PADDING),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .size(32.dp)
                .padding(start = GeneralUnits.BASE_PADDING)
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

        Column() {
            Text(
                text = topBarViewModel.topBarText,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp
            )
        }

        Column(
            modifier = Modifier
                .size(32.dp)
                .padding(end = GeneralUnits.BASE_PADDING)
        ) {
            if (topBarViewModel.isTopBarActionEnabled) {
                IconButton(
                    onClick = {
                        coroutineScope.launch {
                            topBarViewModel.topBarActionFunction()
                        }
                    }
                ) {
                    Icon(topBarViewModel.topBarActionIcon, null)
                }
            }

        }


    }
}