package com.guimor.tennisumpire.ui.screen.player_profile.tabs.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.guimor.tennisumpire.room_database.player.Player
import com.guimor.tennisumpire.ui.components.player.PlayerFullProfileCard

@Composable
fun DetailsTab(
    player: Player?,
) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        PlayerFullProfileCard(player = player)
    }
}