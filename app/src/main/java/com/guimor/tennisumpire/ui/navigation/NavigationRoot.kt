package com.guimor.tennisumpire.ui.navigation

import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.guimor.tennisumpire.preferences_data_store.SettingsViewModel
import com.guimor.tennisumpire.ui.screen.main.MainScreen
import com.guimor.tennisumpire.ui.screen.onboarding.OnBoardingScreen
import com.guimor.tennisumpire.ui.screen.settings.SettingsScreen
import kotlinx.coroutines.runBlocking

@Composable
fun NavigationRoot(
    settingsViewModel: SettingsViewModel = viewModel(factory = SettingsViewModel.Factory)
) {
    //Get settings as reactive flow
    //val settings by settingsViewModel.userSettings.collectAsStateWithLifecycle()

    //I run it blocking for preventing the app ui to build anything before the first screen
    //is decided.
    val settings = runBlocking { settingsViewModel.getUserSettingsValue() }
    val navigationState = rememberNavigationState(
        startRoute =
            if (settings.isOnBoardingFinished) NavRoutesRoot.Main
            else NavRoutesRoot.OnBoarding,
        topLevelRoutes =
            setOf(
                NavRoutesRoot.OnBoarding,
                NavRoutesRoot.Main
            )
    )
    val navigator = remember { Navigator(navigationState) }
    val entryProvider = entryProvider {
        entry<NavRoutesRoot.OnBoarding> {
            OnBoardingScreen(
                onNavigateToMainScreen = {
                    navigator.clearBackStack()
                    navigator.navigate(NavRoutesRoot.Main)
                }
            )
        }
        entry<NavRoutesRoot.Main> {
            MainScreen(
                onNavigateBack = navigator::goBack,
                onNavigateToSettings = { navigator.navigate(NavRoutesRoot.Settings) }
            )
        }
        entry<NavRoutesRoot.Settings> {
            SettingsScreen(
                onNavigateBack = navigator::goBack,
            )
        }
    }
    NavDisplay(
        entries = navigationState.toEntries(entryProvider),
        onBack = navigator::goBack,
        transitionSpec = {
            slideInHorizontally { it } + fadeIn() togetherWith
                    slideOutHorizontally { -it }
        },
        popTransitionSpec = {
            slideInHorizontally { -it } + fadeIn() togetherWith
                    slideOutHorizontally { it }
        },
        predictivePopTransitionSpec = {
            slideInHorizontally { -it } + fadeIn() togetherWith
                    slideOutHorizontally { it }
        },
    )
}