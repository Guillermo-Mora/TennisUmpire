package com.guimor.tennisumpire.ui.screen.main.navigation_bar_screens.rules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.guimor.tennisumpire.dependency_injection.MyApplication
import com.guimor.tennisumpire.room_database.rule.Rule
import com.guimor.tennisumpire.room_database.rule.RuleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RulesViewModel(
    private val ruleRepository: RuleRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow(RulesUiState())
    val uiState = _uiState.asStateFlow()
    val rules: Flow<PagingData<Rule>> = Pager(
        config = PagingConfig(pageSize = 50) )
    { ruleRepository.getAllRules() }
        .flow
        .cachedIn(viewModelScope)

    fun toggleAddRuleToFavourites(ruleUid: Int) {
        viewModelScope.launch {
            //ruleRepository.toggleAddRulesToFavourites(ruleUid)
        }
    }

    fun deleteRule(ruleUid: Int) {
        viewModelScope.launch {
            val ruleName = ruleRepository.getRule(ruleUid).name
            ruleRepository.deleteRule(ruleUid).also { messageResult ->
                _uiState.update { state ->
                    state.copy(
                        messageResult = messageResult,
                        ruleName = ruleName
                    )
                }
            }
        }
    }

    fun resetMessageResult() {
        _uiState.update { state ->
            state.copy(
                messageResult = null,
                ruleName = null
            )
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val ruleRepository = MyApplication.appModule.ruleRepository
                RulesViewModel(
                    ruleRepository = ruleRepository,
                )
            }
        }
    }
}