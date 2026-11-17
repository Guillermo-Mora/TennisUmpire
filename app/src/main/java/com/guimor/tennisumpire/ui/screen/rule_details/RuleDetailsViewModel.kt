package com.guimor.tennisumpire.ui.screen.rule_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.guimor.tennisumpire.dependency_injection.MyApplication
import com.guimor.tennisumpire.room_database.rule.RuleRepository
import com.guimor.tennisumpire.ui.screen.main.navigation_bar_screens.rules.RulesUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class RuleDetailsViewModel(
    private val ruleRepository: RuleRepository,
    val ruleUid: Int
): ViewModel() {
    private val _uiState = MutableStateFlow(RuleDetailsUiState())
    private val _rule = ruleRepository.getRuleFlow(ruleUid)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = null
        )
    val uiState = combine(_uiState, _rule) { uiState, rule ->
        uiState.copy(
            rule = rule
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = RuleDetailsUiState()
    )

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