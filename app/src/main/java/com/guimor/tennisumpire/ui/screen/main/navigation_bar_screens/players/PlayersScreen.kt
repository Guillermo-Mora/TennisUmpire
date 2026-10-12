package com.guimor.tennisumpire.ui.screen.main.navigation_bar_screens.players

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.guimor.tennisumpire.domain.operation_result.result_type.ResultType
import com.guimor.tennisumpire.ui.components.player.PlayerListCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayersScreen(
    onNavigateBack: () -> Unit,
    onNavigateToEditPlayer: (playerUid: Int) -> Unit,
    onNavigateToPlayerProfile: (playerUid: Int) -> Unit,
    scrollBehavior: TopAppBarScrollBehavior,
    viewModel: PlayersViewModel = viewModel(factory = PlayersViewModel.Factory),
    onOperationResult: (result: ResultType) -> Unit,
) {
    //Importante saber esto para más adelante
    //Si añades búsqueda o filtros: deberás recrear el Pager con flatMapLatest
    // sobre el texto de búsqueda, y pasar el parámetro al DAO.
    BackHandler { onNavigateBack() }
    val uiState by viewModel.uiState.collectAsState()
    LaunchedEffect(uiState.messageResult) {
        uiState.messageResult?.let { messageResult ->
            onOperationResult(messageResult)
            viewModel.resetMessageResult()
        }
    }
    val players = viewModel.players.collectAsLazyPagingItems()
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) {
        items(
            count = players.itemCount,
            key = players.itemKey { it.uid }
        ) { index ->
            val player = players[index]
            player?.let { player ->
                PlayerListCard(
                    player = player,
                    onClickToggleAddPlayerToFavourites = {
                        viewModel.toggleAddPlayerToFavourites(
                            playerUid = player.uid
                        )
                    },
                    onClickPlayerProfile = { onNavigateToPlayerProfile(player.uid) },
                    onClickDeletePlayer = { viewModel.deletePlayer(playerUid = player.uid) },
                    onClickEditPlayer = { onNavigateToEditPlayer(player.uid) }
                )
            }
        }
    }
}