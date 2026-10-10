package com.guimor.tennisumpire.ui.screen.edit_player

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.guimor.tennisumpire.R
import com.guimor.tennisumpire.domain.error.Success
import com.guimor.tennisumpire.ui.screen.shared_screen.edit_or_new_player.EditOrNewPlayerViewModel
import com.guimor.tennisumpire.ui.screen.shared_screen.edit_or_new_player.EditOrNewPlayerScreen

@Composable
fun EditPlayerScreen(
    onNavigateBack: () -> Unit,
    onNavigateToSettings: () -> Unit,
    editPlayerViewModel: EditOrNewPlayerViewModel,
    onOperationSuccess: (successResult: Success) -> Unit,
) {
    EditOrNewPlayerScreen(
        onNavigateBack = { onNavigateBack() },
        onNavigateToSettings = { onNavigateToSettings() },
        editPlayerViewModel = editPlayerViewModel,
        onOperationSuccess = { successResult -> onOperationSuccess(successResult) },
        title = stringResource(R.string.edit_player),
        buttonText = stringResource(R.string.save_changes)
    )
}