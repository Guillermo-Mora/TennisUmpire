package com.guimor.tennisumpire.ui.screen.player_profile

import androidx.activity.compose.BackHandler
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.guimor.tennisumpire.R
import com.guimor.tennisumpire.ui.components.player.PlayerTitleCard
import com.guimor.tennisumpire.ui.components.top_bar.NavigateBackIconButton
import com.guimor.tennisumpire.ui.components.top_bar.TitleCustomTopAppBar
import com.guimor.tennisumpire.ui.navigation.Navigator
import com.guimor.tennisumpire.ui.navigation.rememberNavigationState
import com.guimor.tennisumpire.ui.navigation.toEntries
import com.guimor.tennisumpire.ui.screen.player_profile.navigation.NavRoutesPlayerProfile
import com.guimor.tennisumpire.ui.screen.player_profile.tabs.details.DetailsTab
import com.guimor.tennisumpire.ui.screen.player_profile.tabs.matches.MatchesTab
import com.guimor.tennisumpire.ui.screen.player_profile.tabs.statistics.StatisticsTab

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayerProfileScreen(
    onNavigateBack: () -> Unit,
    playerProfileViewModel: PlayerProfileViewModel
) {
    BackHandler { onNavigateBack() }
    val uiState by playerProfileViewModel.uiState.collectAsState()
    val navigationState = rememberNavigationState(
        startRoute = NavRoutesPlayerProfile.Details,
        topLevelRoutes = setOf(
            NavRoutesPlayerProfile.Details,
            NavRoutesPlayerProfile.Matches,
            NavRoutesPlayerProfile.Statistics,
        )
    )
    val navigator = remember { Navigator(navigationState) }
    val entryProvider = entryProvider {
        entry<NavRoutesPlayerProfile.Details> {
            DetailsTab(
                player = uiState.player
            )
        }
        entry<NavRoutesPlayerProfile.Matches> {
            MatchesTab()
        }
        entry<NavRoutesPlayerProfile.Statistics> {
            StatisticsTab()
        }
    }
    val startDestination = Destination.DETAILS
    var selectedDestination by rememberSaveable { mutableIntStateOf(startDestination.ordinal) }
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        topBar = {
            TitleCustomTopAppBar(
                titleContent = {
                    PlayerTitleCard(
                        player = uiState.player,
                        onClickToggleAddPlayerToFavourites = { playerProfileViewModel.toggleAddPlayerToFavourites() },
                    )
                },
                navigationIcon = {
                    NavigateBackIconButton(onNavigateBack = {
                        onNavigateBack()
                    })
                },
                scrollBehavior = scrollBehavior,
                colors = TopAppBarColors(
                    containerColor = TopAppBarDefaults.topAppBarColors().containerColor,
                    scrolledContainerColor = TopAppBarDefaults.topAppBarColors().containerColor,
                    navigationIconContentColor = TopAppBarDefaults.topAppBarColors().navigationIconContentColor,
                    titleContentColor = TopAppBarDefaults.topAppBarColors().titleContentColor,
                    actionIconContentColor = TopAppBarDefaults.topAppBarColors().actionIconContentColor,
                    subtitleContentColor = TopAppBarDefaults.topAppBarColors().subtitleContentColor
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) {
            PrimaryTabRow(
                selectedTabIndex = selectedDestination,
            ) {
                Destination.entries.forEachIndexed { index, destination ->
                    Tab(
                        selected = selectedDestination == index,
                        onClick = {
                            navigator.navigate(destination.route)
                            selectedDestination = index
                        },
                        text = { Text(stringResource(destination.titleId)) }
                    )
                }
            }
            NavDisplay(
                modifier = Modifier.weight(1f),
                entries = navigationState.toEntries(entryProvider),
                onBack = { onNavigateBack() },
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

private enum class Destination(val route: NavKey, val titleId: Int) {
    DETAILS(
        route = NavRoutesPlayerProfile.Details,
        titleId = R.string.details
    ),
    MATCHES(
        route = NavRoutesPlayerProfile.Matches,
        titleId = R.string.matches
    ),
    STATISTICS(
        route = NavRoutesPlayerProfile.Statistics,
        titleId = R.string.statistics
    )
}