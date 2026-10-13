package com.guimor.tennisumpire.ui.screen.new_rule

import androidx.compose.runtime.Composable
import com.guimor.tennisumpire.domain.ui_messages.ResultWithUiText
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