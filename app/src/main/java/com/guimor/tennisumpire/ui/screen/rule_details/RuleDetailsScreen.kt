package com.guimor.tennisumpire.ui.screen.rule_details

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.guimor.tennisumpire.domain.ui_messages.ResultWithUiText
import com.guimor.tennisumpire.ui.components.player.PlayerTitleCard
import com.guimor.tennisumpire.ui.components.top_bar.NavigateBackIconButton
import com.guimor.tennisumpire.ui.components.top_bar.TitleCustomTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RuleDetailsScreen(
    onNavigateBack: () -> Unit,
    ruleDetailsViewModel: RuleDetailsViewModel,
    onOperationSuccess: (resultWithUiText: ResultWithUiText) -> Unit,
) {
    BackHandler { onNavigateBack() }
    val uiState by ruleDetailsViewModel.uiState.collectAsState()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        topBar = {
            TitleCustomTopAppBar(
                titleContent = {
                    /*
                    PlayerTitleCard(
                        player = uiState.,
                        onClickToggleAddPlayerToFavourites = { playerProfileViewModel.toggleAddPlayerToFavourites() },
                    )
                     */
                },
                navigationIcon = {
                    NavigateBackIconButton(onNavigateBack = {
                        onNavigateBack()
                    })
                },
                scrollBehavior = scrollBehavior,
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) {

        }
    }
}