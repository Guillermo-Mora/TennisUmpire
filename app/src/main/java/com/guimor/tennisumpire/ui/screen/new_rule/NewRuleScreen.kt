package com.guimor.tennisumpire.ui.screen.new_rule

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.guimor.tennisumpire.domain.ui_messages.ResultWithUiText
import com.guimor.tennisumpire.room_database.rule.FakeRuleRepository
import com.guimor.tennisumpire.ui.screen.shared_screen.edit_or_new_rule.EditOrNewRuleScreen
import com.guimor.tennisumpire.ui.screen.shared_screen.edit_or_new_rule.EditOrNewRuleViewModel

@Composable
fun NewRuleScreen(
    onNavigateBack: () -> Unit,
    newRuleViewModel: EditOrNewRuleViewModel,
    onOperationSuccess: (resultWithUiText: ResultWithUiText) -> Unit,
) {
    EditOrNewRuleScreen(
        onNavigateBack = { onNavigateBack() },
        editOrNewRuleViewModel = newRuleViewModel,
        onOperationSuccess = {resultWithUiText -> onOperationSuccess(resultWithUiText)},
        title = "New rule",
        buttonText = "Create rule"
    )
}

@Composable
@Preview
fun NewRuleScreenPreview() {
    MaterialTheme {
        EditOrNewRuleScreen(
            onNavigateBack = {},
            editOrNewRuleViewModel = viewModel {
                EditOrNewRuleViewModel(
                    ruleRepository = FakeRuleRepository()
                )
            },
            onOperationSuccess = {},
            title = "New Rule",
            buttonText = "Create rule"
        )
    }
}