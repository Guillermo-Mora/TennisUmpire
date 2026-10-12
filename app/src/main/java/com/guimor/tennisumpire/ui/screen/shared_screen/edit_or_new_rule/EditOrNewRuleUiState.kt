package com.guimor.tennisumpire.ui.screen.shared_screen.edit_or_new_rule

import com.guimor.tennisumpire.domain.operation_result.result_type.ResultType
import com.guimor.tennisumpire.ui_state.BaseUiState

data class EditOrNewRuleUiState(
    val scrollToErrorSection: Int = -1,
    val operationResult: ResultType? = null
): BaseUiState()