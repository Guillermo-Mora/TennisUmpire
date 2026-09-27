package com.guimor.tennisumpire.ui.screen.players

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.guimor.tennisumpire.domain.error.MessageResult
import com.guimor.tennisumpire.ui.components.player.PlayerListCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayersScreen(
    onNavigateBack: () -> Unit,
    scrollBehavior: TopAppBarScrollBehavior,
    viewModel: PlayersViewModel = viewModel(factory = PlayersViewModel.Factory),
    onOperationResult: (result: MessageResult) -> Unit,
) {
    BackHandler { onNavigateBack() }
    val uiState by viewModel.uiState.collectAsState()
    LaunchedEffect(uiState.messageResult) {
        uiState.messageResult?.let { messageResult ->
            onOperationResult(messageResult)
            viewModel.resetMessageResult()
        }
    }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) {
        items(uiState.players) { player ->
            PlayerListCard(
                player = player,
                onClickToggleAddPlayerToFavourites = {
                    viewModel.toggleAddPlayerToFavourites(
                        playerUid = player.uid
                    )
                },
                onClickDeletePlayer = { viewModel.deletePlayer(playerUid = player.uid) }
            )
        }
    }
}