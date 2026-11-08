package com.guimor.tennisumpire.ui.screen.edit_rule

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.guimor.tennisumpire.R
import com.guimor.tennisumpire.domain.ui_messages.ResultWithUiText
import com.guimor.tennisumpire.room_database.rule.FakeRuleRepository
import com.guimor.tennisumpire.ui.screen.shared_screen.edit_or_new_rule.EditOrNewRuleScreen
import com.guimor.tennisumpire.ui.screen.shared_screen.edit_or_new_rule.EditOrNewRuleViewModel

@Composable
fun EditRuleScreen(
    onNavigateBack: () -> Unit,
    editRuleViewModel: EditOrNewRuleViewModel,
    onOperationSuccess: (resultWithUiText: ResultWithUiText) -> Unit,
) {
    EditOrNewRuleScreen(
        onNavigateBack = { onNavigateBack() },
        editOrNewRuleViewModel = editRuleViewModel,
        onOperationSuccess = { resultWithUiText -> onOperationSuccess(resultWithUiText) },
        title = "Edit rule",
        buttonText = stringResource(R.string.save_changes)
    )
}

@Composable
@Preview
fun EditRuleScreenPreview() {
    MaterialTheme {
        EditOrNewRuleScreen(
            onNavigateBack = {},
            editOrNewRuleViewModel = viewModel {
                EditOrNewRuleViewModel(
                    ruleRepository = FakeRuleRepository()
                )
            },
            onOperationSuccess = {},
            title = "Edit Rule",
            buttonText = stringResource(R.string.save_changes)
        )
    }
}