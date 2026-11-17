package com.guimor.tennisumpire.ui.screen.rule_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.guimor.tennisumpire.dependency_injection.MyApplication
import com.guimor.tennisumpire.room_database.rule.RuleRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RuleDetailsViewModel(
    private val ruleRepository: RuleRepository,
    val ruleUid: Int
): ViewModel() {
    private val _uiState = MutableStateFlow(RuleDetailsUiState())
    val uiState = _uiState.asStateFlow()

    companion object {
        fun Factory(
            ruleUid: Int,
        ): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val ruleRepository = MyApplication.appModule.ruleRepository
                RuleDetailsViewModel(
                    ruleRepository = ruleRepository,
                    ruleUid = ruleUid,
                )
            }
        }
    }
}