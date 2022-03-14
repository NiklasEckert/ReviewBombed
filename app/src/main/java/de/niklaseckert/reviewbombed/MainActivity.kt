package de.niklaseckert.reviewbombed

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import de.niklaseckert.reviewbombed.core.presentation.TopBarState
import de.niklaseckert.reviewbombed.core.presentation.TopBarViewModel
import de.niklaseckert.reviewbombed.feature_login.presentation.AccountState
import de.niklaseckert.reviewbombed.feature_login.presentation.AccountViewModel
import de.niklaseckert.reviewbombed.ui.components.ApplicationSwitcher
import de.niklaseckert.reviewbombed.ui.theme.ReviewBombedTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val accountState by viewModels<AccountViewModel>()
    private val topBarState by viewModels<TopBarViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReviewBombedTheme {

                CompositionLocalProvider(
                    AccountState provides accountState,
                    TopBarState provides topBarState,
                ) {
                    ApplicationSwitcher()
                }
            }
        }
    }

    @Preview
    @Composable
    fun Preview() {
        onCreate(null)
    }
}