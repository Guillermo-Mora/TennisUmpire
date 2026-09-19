package com.guimor.tennisumpire.ui.screen.players

import com.guimor.tennisumpire.room_database.player.Player
import com.guimor.tennisumpire.ui_state.BaseUiState

data class PlayersUiState(
    val players: List<Player> = emptyList()
) : BaseUiState()