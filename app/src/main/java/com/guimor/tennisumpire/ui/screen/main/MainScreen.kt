package com.guimor.tennisumpire.ui.screen.main

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.guimor.tennisumpire.icons.groupsIcon
import com.guimor.tennisumpire.icons.library_booksIcon
import com.guimor.tennisumpire.icons.settingsIcon
import com.guimor.tennisumpire.icons.sports_tennisIcon
import com.guimor.tennisumpire.ui.navigation.Navigator
import com.guimor.tennisumpire.ui.navigation.toEntries
import com.guimor.tennisumpire.ui.screen.main.navigation.NavRoutesMain
import com.guimor.tennisumpire.ui.screen.main.navigation.NavigationMain
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
    onNavigateToSettings: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val navigationState = NavigationMain.getRememberNavigationState()
    //I still don't know if rememberSaveable is necessary or not here.
    //I have to try with screen rotations, theme changing, variables resetting, etc.
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
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(navigationState.topLevelRoute.getTitle()) },
                //navigationIcon = { },
                actions = {
                    IconButton(
                        onClick = {
                            onNavigateToSettings()
                        }
                    ) {
                        Icon(
                            imageVector = settingsIcon,
                            contentDescription = "",
                        )
                    }
                },
                modifier = Modifier
                    .padding(horizontal = 16.dp),
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    onClick = { navigator.navigate(NavRoutesMain.Matches) },
                    icon = {
                        Icon(
                            imageVector = sports_tennisIcon,
                            contentDescription = "Matches",
                        )
                    },
                    label = { Text("Matches") },
                    selected = navigationState.topLevelRoute == NavRoutesMain.Matches,
                )
                NavigationBarItem(
                    onClick = { navigator.navigate(NavRoutesMain.Results) },
                    icon = {
                        Icon(
                            imageVector = library_booksIcon,
                            contentDescription = "Results",
                        )
                    },
                    label = { Text("Results") },
                    selected = navigationState.topLevelRoute == NavRoutesMain.Results,
                )
                NavigationBarItem(
                    onClick = { navigator.navigate(NavRoutesMain.Players) },
                    icon = {
                        Icon(
                            imageVector = groupsIcon,
                            contentDescription = "Players",
                        )
                    },
                    label = { Text("Players") },
                    selected = navigationState.topLevelRoute == NavRoutesMain.Players,
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
        onNavigateBack = {}
    ) {}
}