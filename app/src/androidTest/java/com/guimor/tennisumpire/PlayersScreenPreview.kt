package com.guimor.tennisumpire

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.guimor.tennisumpire.ui.screen.players.PlayersScreen
import com.guimor.tennisumpire.ui.screen.players.PlayersViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PlayersScreenPreview() {
    PlayersScreen(
        onNavigateBack = { },
        scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(),
        viewModel = viewModel {
            PlayersViewModel(
                playerRepository = FakePlayerRepository()
            )
        }
    )
}