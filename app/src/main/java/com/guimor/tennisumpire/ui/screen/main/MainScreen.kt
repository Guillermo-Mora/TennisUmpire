package com.guimor.tennisumpire.ui.screen.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import com.guimor.tennisumpire.icons.addIcon
import com.guimor.tennisumpire.icons.groupsFilledIcon
import com.guimor.tennisumpire.icons.groupsIcon
import com.guimor.tennisumpire.icons.library_booksFilledIcon
import com.guimor.tennisumpire.icons.library_booksIcon
import com.guimor.tennisumpire.icons.sports_tennisFilledIcon
import com.guimor.tennisumpire.icons.sports_tennisIcon
import com.guimor.tennisumpire.ui.components.navigation_bar.BaseNavigationBarItem
import com.guimor.tennisumpire.ui.components.top_bar.MainTopAppBar
import com.guimor.tennisumpire.ui.navigation.NavRoutesRoot
import com.guimor.tennisumpire.ui.navigation.Navigator
import com.guimor.tennisumpire.ui.navigation.toEntries
import com.guimor.tennisumpire.ui.screen.main.navigation.NavRoutesMain
import com.guimor.tennisumpire.ui.screen.main.navigation.NavigationMain
import com.guimor.tennisumpire.ui.screen.main.navigation.getFabDescription
import com.guimor.tennisumpire.ui.screen.main.navigation.getTitle
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
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val navigationState = NavigationMain.getRememberNavigationState()
    val navigator = remember { Navigator(navigationState) }
    val entryProvider = entryProvider {
        entry<NavRoutesMain.Matches> {
            MatchesScreen(

            )
        }
        entry<NavRoutesMain.Results> {
            ResultsScreen(

            )
        }
        entry<NavRoutesMain.Players> {
            PlayersScreen(

            )
        }
    }

    fun isScreenSelected(route: NavKey) = navigationState.topLevelRoute == route
    Scaffold(
        topBar = {
            MainTopAppBar(
                title = navigationState.topLevelRoute.getTitle(),
                onNavigateToSettings = { onNavigateToSettings() }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    when (navigationState.topLevelRoute) {
                        NavRoutesMain.Matches -> {
                            onNavigateToNewMatch()
                        }

                        NavRoutesMain.Results -> {
                            onNavigateToNewResult()
                        }

                        NavRoutesMain.Players -> {
                            onNavigateToNewPlayer()
                        }
                    }
                }
            ) {
                Icon(
                    imageVector = addIcon,
                    contentDescription = navigationState.topLevelRoute.getFabDescription(),
                )
            }
        },
        bottomBar = {
            NavigationBar {
                BaseNavigationBarItem(
                    route = NavRoutesMain.Matches,
                    onClick = navigator::navigate,
                    selected = ::isScreenSelected,
                    label = "Matches",
                    icon = sports_tennisIcon,
                    iconSelected = sports_tennisFilledIcon,
                )
                BaseNavigationBarItem(
                    route = NavRoutesMain.Results,
                    onClick = navigator::navigate,
                    selected = ::isScreenSelected,
                    label = "Results",
                    icon = library_booksIcon,
                    iconSelected = library_booksFilledIcon,
                )
                BaseNavigationBarItem(
                    route = NavRoutesMain.Players,
                    onClick = navigator::navigate,
                    selected = ::isScreenSelected,
                    label = "Players",
                    icon = groupsIcon,
                    iconSelected = groupsFilledIcon
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavigationMain.GetNavDisplay(
                entries = navigationState.toEntries(entryProvider),
                onBack = navigator::goBack
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