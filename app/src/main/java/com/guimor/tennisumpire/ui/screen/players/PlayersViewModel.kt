package com.guimor.tennisumpire.ui.screen.players

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.guimor.tennisumpire.dependency_injection.MyApplication
import com.guimor.tennisumpire.room_database.player.PlayerRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class PlayersViewModel(
    private val playerRepository: PlayerRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow(PlayersUiState())
    private val _players = playerRepository.getAllPlayers()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = emptyList()
        )
    val uiState = combine(_uiState, _players) { uiState, players ->
        uiState.copy(
            players = players
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = PlayersUiState()
    )

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