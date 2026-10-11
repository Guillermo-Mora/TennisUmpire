package com.guimor.tennisumpire.ui.screen.main.navigation_bar_screens.players

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.guimor.tennisumpire.dependency_injection.MyApplication
import com.guimor.tennisumpire.room_database.player.Player
import com.guimor.tennisumpire.room_database.player.PlayerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PlayersViewModel(
    private val playerRepository: PlayerRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow(PlayersUiState())
    val uiState = _uiState.asStateFlow()
    val players: Flow<PagingData<Player>> = Pager(
        config = PagingConfig(pageSize = 50) )
    { playerRepository.getAllPlayers() }
        .flow
        .cachedIn(viewModelScope)

    fun toggleAddPlayerToFavourites(playerUid: Int) {
        viewModelScope.launch {
            playerRepository.toggleAddPlayerToFavourites(playerUid)
        }
    }

    fun deletePlayer(playerUid: Int) {
        viewModelScope.launch {
            playerRepository.deletePlayer(playerUid).also { messageResult ->
                _uiState.update { state ->
                    state.copy(
                        messageResult = messageResult
                    )
                }
            }
        }
    }

    fun resetMessageResult() {
        _uiState.update { state ->
            state.copy(
                messageResult = null
            )
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val playerRepository = MyApplication.appModule.playerRepository
                PlayersViewModel(
                    playerRepository = playerRepository,
                )
            }
        }
    }
}