package com.guimor.tennisumpire.ui.screen.player_profile

import com.guimor.tennisumpire.room_database.player.Player
import com.guimor.tennisumpire.ui_state.BaseUiState

data class PlayerProfileUiState(
    val player: Player? = null
) : BaseUiState()