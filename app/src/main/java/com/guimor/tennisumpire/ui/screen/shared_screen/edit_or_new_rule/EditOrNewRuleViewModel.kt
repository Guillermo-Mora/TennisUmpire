package com.guimor.tennisumpire.ui.screen.shared_screen.edit_or_new_rule

import androidx.lifecycle.ViewModel
import com.guimor.tennisumpire.room_database.rule.RuleRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class EditOrNewRuleViewModel(
    private val ruleRepository: RuleRepositoryImpl,
    private val ruleUid: Int? = null
) : ViewModel() {
    private val _uiState = MutableStateFlow(EditOrNewRuleUiState())
    val uiState = _uiState.asStateFlow()

    fun resetScrollToError() {
        _uiState.update { state -> state.copy(scrollToErrorSection = -1) }
    }

    fun resetOperationResult() {
        _uiState.update { state -> state.copy(operationResult = null) }
    }
}