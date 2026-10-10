package com.guimor.tennisumpire.ui.screen.new_player

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.guimor.tennisumpire.R
import com.guimor.tennisumpire.domain.error.Success
import com.guimor.tennisumpire.ui.screen.shared_screen.edit_or_new_player.EditOrNewPlayerScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewPlayerScreen(
    onNavigateBack: () -> Unit,
    onNavigateToSettings: () -> Unit,
    newPlayerViewModel: NewPlayerViewModel,
    onOperationSuccess: (successResult: Success) -> Unit,
) {
    EditOrNewPlayerScreen(
        onNavigateBack = { onNavigateBack() },
        onNavigateToSettings = { onNavigateToSettings() },
        editPlayerViewModel = newPlayerViewModel,
        onOperationSuccess = { successResult -> onOperationSuccess(successResult) },
        title = stringResource(R.string.new_player),
        buttonText = stringResource(R.string.create_player)
    )
}