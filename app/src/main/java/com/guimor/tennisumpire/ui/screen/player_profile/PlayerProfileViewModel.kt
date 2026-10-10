package com.guimor.tennisumpire.ui.screen.player_profile

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
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PlayerProfileViewModel(
    private val playerRepository: PlayerRepository,
    val playerUid: Int
) : ViewModel() {
    private val _uiState = MutableStateFlow(PlayerProfileUiState())
    private val _player = playerRepository.getPlayerFlow(playerUid)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = null
        )
    val uiState = combine(_uiState, _player) { uiState, player ->
        uiState.copy(
            player = player
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = PlayerProfileUiState()
    )
    fun toggleAddPlayerToFavourites() {
        viewModelScope.launch {
            playerRepository.toggleAddPlayerToFavourites(playerUid)
        }
    }

    init {
        viewModelScope.launch {
            _uiState.update { state ->
                state.copy(
                    player = playerRepository.getPlayer(playerUid)
                )
            }
        }
    }

    companion object {
        fun Factory(
            playerUid: Int,
        ): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val playerRepository = MyApplication.appModule.playerRepository
                PlayerProfileViewModel(
                    playerRepository = playerRepository,
                    playerUid = playerUid,
                )
            }
        }
    }
}