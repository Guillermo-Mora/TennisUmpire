package com.guimor.tennisumpire.ui.screen.shared_screen.edit_or_new_rule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.guimor.tennisumpire.dependency_injection.MyApplication
import com.guimor.tennisumpire.room_database.rule.RuleRepository
import com.guimor.tennisumpire.room_database.rule.RuleRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class EditOrNewRuleViewModel(
    private val ruleRepository: RuleRepository,
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

    companion object {
        fun Factory(
            ruleUid: Int? = null,
        ): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val ruleRepository = MyApplication.appModule.ruleRepository
                EditOrNewRuleViewModel(
                    ruleRepository = ruleRepository,
                    ruleUid = ruleUid
                )
            }
        }
    }
}