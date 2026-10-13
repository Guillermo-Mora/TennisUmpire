package com.guimor.tennisumpire.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.guimor.tennisumpire.FakeRuleRepository
import com.guimor.tennisumpire.ui.screen.shared_screen.edit_or_new_rule.EditOrNewRuleScreen
import com.guimor.tennisumpire.ui.screen.shared_screen.edit_or_new_rule.EditOrNewRuleViewModel

@Composable
@Preview
fun NewRuleScreenPreview() {
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