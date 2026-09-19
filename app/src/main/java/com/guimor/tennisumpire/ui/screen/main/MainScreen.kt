package com.guimor.tennisumpire.ui.screen.main

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberDecoratedNavEntries
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.runtime.result.ResultEffect
import androidx.navigation3.runtime.result.rememberResultEventBusNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.guimor.tennisreferee.R
import com.guimor.tennisumpire.domain.error.OperationResult
import com.guimor.tennisumpire.ui.components.navigation_bar.BaseNavigationBarItem
import com.guimor.tennisumpire.ui.components.navigation_bar.BaseNavigationBarItemData
import com.guimor.tennisumpire.ui.components.snackbar_host.OperationSnackBarHost
import com.guimor.tennisumpire.ui.components.snackbar_host.OperationSnackbarVisuals
import com.guimor.tennisumpire.ui.components.top_bar.MainTopAppBar
import com.guimor.tennisumpire.ui.icons.groupsFilledIcon
import com.guimor.tennisumpire.ui.icons.groupsIcon
import com.guimor.tennisumpire.ui.icons.library_booksFilledIcon
import com.guimor.tennisumpire.ui.icons.library_booksIcon
import com.guimor.tennisumpire.ui.icons.sports_tennisFilledIcon
import com.guimor.tennisumpire.ui.icons.sports_tennisIcon
import com.guimor.tennisumpire.ui.navigation.Navigator
import com.guimor.tennisumpire.ui.navigation.rememberNavigationState
import com.guimor.tennisumpire.ui.navigation.toEntries
import com.guimor.tennisumpire.ui.screen.main.MainScreensProperties.function
import com.guimor.tennisumpire.ui.screen.main.MainScreensProperties.options
import com.guimor.tennisumpire.ui.screen.main.navigation.NavRoutesMain
import com.guimor.tennisumpire.ui.screen.matches.MatchesScreen
import com.guimor.tennisumpire.ui.screen.players.PlayersScreen
import com.guimor.tennisumpire.ui.screen.results.ResultsScreen

/*
Text("On app launch, you will appear in matches screen")
Text("Inside here, you will be able to se matches ordered by date")
Text("You will also be able to filter them by player")
Text("You will also be able to delete matches")
Text("You will also be able to create folders for storing matches in custom folders" +
" Such as tournament x, or summer matches, etc")
Text("You will also be able to add matches to favourites")
Text("Inside each match, you can see all statistics (Do it like Sofascore)")
Text("On the players tab, you can create new players, add name, style (" +
"Backhand, weight, height, born date, profile picture, etc)")
Text("On each player tab, you can see their matches and global stats")
Text("When tapping on creating a new match, you will navigate to a different new window" +
" where you select all details before starting it, such as best of x, etc")
Text("For storing everything, I think I will use SQLDelight")
Text("I will also add an option for exporting the data from the app database")
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel = viewModel { MainViewModel() },
    onNavigateBack: () -> Unit,
    onNavigateToSettings: () -> Unit,
    onNavigateToNewMatch: () -> Unit,
    onNavigateToNewResult: () -> Unit,
    onNavigateToNewPlayer: () -> Unit
) {
    val topLevelRoutes = setOf(
        NavRoutesMain.Matches,
        NavRoutesMain.Results,
        NavRoutesMain.Players
    )
    val navigationState = rememberNavigationState(
        startRoute = NavRoutesMain.Matches,
        topLevelRoutes = topLevelRoutes
    )
    val navigator = remember { Navigator(navigationState) }
    val navigationBarItemsData = listOf(
        BaseNavigationBarItemData(
            newRoute = NavRoutesMain.Matches,
            label = stringResource(R.string.matches),
            icon = sports_tennisIcon,
            iconSelected = sports_tennisFilledIcon
        ),
        BaseNavigationBarItemData(
            newRoute = NavRoutesMain.Results,
            label = stringResource(R.string.results),
            icon = library_booksIcon,
            iconSelected = library_booksFilledIcon
        ),
        BaseNavigationBarItemData(
            newRoute = NavRoutesMain.Players,
            label = stringResource(R.string.players),
            icon = groupsIcon,
            iconSelected = groupsFilledIcon
        )
    )
    //Scroll behavior for each individual screen
    val matchesScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val resultsScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val playersScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val entryProvider = entryProvider {
        entry<NavRoutesMain.Matches> {
            MatchesScreen(
                scrollBehavior = matchesScrollBehavior
            )
        }
        entry<NavRoutesMain.Results> {
            ResultsScreen(
                scrollBehavior = resultsScrollBehavior,
                onNavigateBack = {
                    viewModel.changeMainScreen(navigator.goBackAndGetNewRoute())
                }
            )
        }
        entry<NavRoutesMain.Players> {
            PlayersScreen(
                scrollBehavior = playersScrollBehavior,
                onNavigateBack = {
                    viewModel.changeMainScreen(navigator.goBackAndGetNewRoute())
                },
            )
        }
    }
    val snackBarHostState = remember { SnackbarHostState() }
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    ResultEffect<OperationResult.Success>(resultKey = "success_result") { successResult ->
        snackBarHostState.showSnackbar(
            visuals = OperationSnackbarVisuals(
                operationResult = successResult,
                duration = SnackbarDuration.Short
            ),
        )
    }

    fun isScreenSelected(route: NavKey) = navigationState.topLevelRoute == route
    Scaffold(
        snackbarHost = { OperationSnackBarHost(snackBarHostState = snackBarHostState) },
        topBar = {
            MainTopAppBar(
                title = stringResource(uiState.mainScreenData.title),
                onNavigateToSettings = { onNavigateToSettings() },
                scrollBehavior = (navigationState.topLevelRoute).options(
                    matchesScreen = matchesScrollBehavior,
                    resultsScreen = resultsScrollBehavior,
                    playersScreen = playersScrollBehavior,
                    empty = matchesScrollBehavior
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    (navigationState.topLevelRoute).function(
                        matchesScreen = { onNavigateToNewMatch() },
                        resultsScreen = { onNavigateToNewResult() },
                        playersScreen = { onNavigateToNewPlayer() },
                    )
                }
            ) {
                Icon(
                    imageVector = uiState.mainScreenData.fabIcon,
                    contentDescription = stringResource(uiState.mainScreenData.fabDescription),
                )
            }
        },
        bottomBar = {
            NavigationBar {
                navigationBarItemsData.forEach {
                    BaseNavigationBarItem(
                        currentRoute = navigationState.topLevelRoute,
                        newRoute = it.newRoute,
                        onClick = navigator::navigate,
                        updateScreenData = viewModel::changeMainScreen,
                        selected = ::isScreenSelected,
                        label = it.label,
                        icon = it.icon,
                        iconSelected = it.iconSelected
                    )
                }
            }
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavDisplay(
                entries = navigationState.toEntries(entryProvider),
                onBack = navigator::goBack,
                transitionSpec = {
                    slideInHorizontally { it } + fadeIn() togetherWith
                            slideOutHorizontally { -it } + fadeOut()
                },
                popTransitionSpec = {
                    slideInHorizontally { -it } + fadeIn() togetherWith
                            slideOutHorizontally { it } + fadeOut()
                },
                predictivePopTransitionSpec = {
                    slideInHorizontally { -it } + fadeIn() togetherWith
                            slideOutHorizontally { it } + fadeOut()
                },
            )
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen(
        onNavigateBack = {},
        onNavigateToSettings = {},
        onNavigateToNewMatch = {},
        onNavigateToNewPlayer = {},
        onNavigateToNewResult = {}
    )
}