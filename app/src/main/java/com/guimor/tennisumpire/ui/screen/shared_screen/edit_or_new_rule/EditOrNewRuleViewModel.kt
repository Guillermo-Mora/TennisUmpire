package com.guimor.tennisumpire.ui.screen.shared_screen.edit_or_new_rule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.guimor.tennisumpire.dependency_injection.MyApplication
import com.guimor.tennisumpire.domain.model.rule.RuleOnGameDeuce
import com.guimor.tennisumpire.domain.model.rule.RuleSetDecider
import com.guimor.tennisumpire.domain.model.rule.RuleSetType
import com.guimor.tennisumpire.domain.model.rule.RuleSetsQuantityType
import com.guimor.tennisumpire.domain.model.rule.RuleTiebreakDecider
import com.guimor.tennisumpire.domain.operation_result.result_type.FormatError
import com.guimor.tennisumpire.domain.operation_result.result_type.ResultType
import com.guimor.tennisumpire.room_database.rule.Rule
import com.guimor.tennisumpire.room_database.rule.RuleRepository
import com.guimor.tennisumpire.room_database.rule.SetRules
import com.guimor.tennisumpire.ui.model.FormFieldData
import com.guimor.tennisumpire.view_model.ValidatableForm
import com.guimor.tennisumpire.view_model.ViewModelHelper
import com.guimor.tennisumpire.view_model.validationDebounce
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

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

    fun canIncrementNumber(currentValue: Int): Boolean {
        return currentValue < MAX_NUMBER
    }

    fun canDecrementNumber(currentValue: Int): Boolean {
        return currentValue > MIN_NUMBER
    }

    fun canIncrementSets(currentValue: Int): Boolean {
        return if (uiState.value.ruleSetsQuantityType == RuleSetsQuantityType.BEST_OF) {
            currentValue + 1 < MAX_NUMBER
        } else currentValue < MAX_NUMBER
    }

    fun canDecrementSets(currentValue: Int): Boolean {
        return if (uiState.value.ruleSetsQuantityType == RuleSetsQuantityType.BEST_OF) {
            currentValue - 1 > MIN_NUMBER
        } else currentValue > MIN_NUMBER
    }

    //Normal rules

    private val debounceValidateRuleName = validationDebounce { validateRuleName() }
    fun setRuleName(newName: String) {
        _uiState.update { state ->
            state.copy(
                ruleName = FormFieldData(
                    value = newName,
                    error = null
                )
            )
        }
        debounceValidateRuleName()
    }

    private fun validateRuleName(): Boolean {
        return ViewModelHelper.isFieldError(
            formFieldData = uiState.value.ruleName,
            required = true,
            ViewModelHelper.ValidationRule(
                condition = String::isBlank,
                error = FormatError.IS_BLANK
            )
        ) { _uiState.update { state -> state.copy(ruleName = it) } }
    }

    fun setSetsQuantityType(setsQuantityType: RuleSetsQuantityType) {
        _uiState.update { state ->
            state.copy(
                ruleSetsQuantityType = setsQuantityType,
                ruleSetsQuantity =
                    if (
                        setsQuantityType == RuleSetsQuantityType.BEST_OF &&
                        uiState.value.ruleSetsQuantity % 2 == 0
                    ) {
                        uiState.value.ruleSetsQuantity + 1
                    } else uiState.value.ruleSetsQuantity,
                areDecidingSetRulesDifferent =
                    if (setsQuantityType == RuleSetsQuantityType.FIXED_QUANTITY) false
                    else uiState.value.areDecidingSetRulesDifferent
            )
        }
    }

    fun setSetsQuantity(newValue: Int) {
        _uiState.update { state ->
            state.copy(
                ruleSetsQuantity = newValue,
                areDecidingSetRulesDifferent =
                    if (newValue == 1) false
                    else uiState.value.areDecidingSetRulesDifferent
            )
        }
    }

    fun setSetsType(setType: RuleSetType) {
        _uiState.update { state ->
            state.copy(
                ruleGlobalSetType = setType
            )
        }
    }

    fun setGamesPerSet(newValue: Int) {
        _uiState.update { state ->
            state.copy(
                ruleGlobalGamesPerSet = newValue
            )
        }
    }

    fun setSetDecider(setDecider: RuleSetDecider) {
        _uiState.update { state ->
            state.copy(
                ruleGlobalSetDecider = setDecider
            )
        }
    }

    fun setOnGameDeuce(onGameDeuce: RuleOnGameDeuce) {
        _uiState.update { state ->
            state.copy(
                ruleGlobalOnGameDeuce = onGameDeuce
            )
        }
    }

    fun setPointsPerTiebreak(newValue: Int) {
        _uiState.update { state ->
            state.copy(
                ruleGlobalPointsPerTiebreak = newValue
            )
        }
    }

    fun setTiebreakDecider(tiebreakDecider: RuleTiebreakDecider) {
        _uiState.update { state ->
            state.copy(
                ruleGlobalTiebreakDecider = tiebreakDecider
            )
        }
    }

    fun setDecidingSet(boolean: Boolean) {
        _uiState.update { state ->
            state.copy(
                areDecidingSetRulesDifferent = boolean
            )
        }
    }

    //Deciding set rules
    fun setDecidingSetType(setType: RuleSetType) {
        _uiState.update { state ->
            state.copy(
                ruleDecidingSetType = setType
            )
        }
    }

    fun setDecidingGamesPerSet(newValue: Int) {
        _uiState.update { state ->
            state.copy(
                ruleDecidingGamesPerSet = newValue
            )
        }
    }

    fun setDecidingSetDecider(setDecider: RuleSetDecider) {
        _uiState.update { state ->
            state.copy(
                ruleDecidingSetDecider = setDecider
            )
        }
    }

    fun setDecidingOnGameDeuce(onGameDeuce: RuleOnGameDeuce) {
        _uiState.update { state ->
            state.copy(
                ruleDecidingOnGameDeuce = onGameDeuce
            )
        }
    }

    fun setDecidingPointsPerTiebreak(newValue: Int) {
        _uiState.update { state ->
            state.copy(
                ruleDecidingPointsPerTiebreak = newValue
            )
        }
    }

    fun setDecidingTiebreakDecider(tiebreakDecider: RuleTiebreakDecider) {
        _uiState.update { state ->
            state.copy(
                ruleDecidingTiebreakDecider = tiebreakDecider
            )
        }
    }

    fun validateForm(): RequestableFieldsIDs? {
        var firstErrorFieldID: RequestableFieldsIDs? = null
        if (validateRuleName()) firstErrorFieldID = RequestableFieldsIDs.RULE_NAME
        if (firstErrorFieldID != null) return firstErrorFieldID
        viewModelScope.launch {
            val operationResult: ResultType = ruleRepository.insertRule(
                getCleanedRule(uiState.value)
            )
            _uiState.update { state -> state.copy(operationResult = operationResult) }
        }
        return null
    }

    private fun getCleanedRule(
        ruleData: EditOrNewRuleUiState
    ): Rule {
        return Rule(
            name = ruleData.ruleName.value,
            setsQuantityType = ruleData.ruleSetsQuantityType,
            setsQuantity = ruleData.ruleSetsQuantity,
            setRules = getCleanedSetRules(
                setType = ruleData.ruleGlobalSetType,
                gamesPerSet = ruleData.ruleGlobalGamesPerSet,
                onGameDeuce = ruleData.ruleGlobalOnGameDeuce,
                setDecider = ruleData.ruleGlobalSetDecider,
                pointsPerTiebreak = ruleData.ruleGlobalPointsPerTiebreak,
                tiebreakDecider = ruleData.ruleGlobalTiebreakDecider
            ),
            decidingSetRules = if (ruleData.areDecidingSetRulesDifferent) getCleanedSetRules(
                setType = ruleData.ruleDecidingSetType,
                gamesPerSet = ruleData.ruleDecidingGamesPerSet,
                onGameDeuce = ruleData.ruleDecidingOnGameDeuce,
                setDecider = ruleData.ruleDecidingSetDecider,
                pointsPerTiebreak = ruleData.ruleDecidingPointsPerTiebreak,
                tiebreakDecider = ruleData.ruleDecidingTiebreakDecider
            ) else null
        )
    }

    private fun getCleanedSetRules(
        setType: RuleSetType,
        gamesPerSet: Int,
        onGameDeuce: RuleOnGameDeuce,
        setDecider: RuleSetDecider,
        pointsPerTiebreak: Int,
        tiebreakDecider: RuleTiebreakDecider
    ): SetRules {
        return SetRules(
            setType = setType,
            gamesPerSet =
                if (setType == RuleSetType.GAMES)
                    gamesPerSet
                else null,
            onGameDeuce =
                if (setType == RuleSetType.GAMES)
                    onGameDeuce
                else null,
            setDecider = setDecider,
            pointsPerTiebreak =
                if (setDecider == RuleSetDecider.TIEBREAK)
                    pointsPerTiebreak
                else null,
            tiebreakDecider =
                if (setDecider == RuleSetDecider.TIEBREAK)
                    tiebreakDecider
                else null
        )
    }

    companion object {
        private const val MAX_NUMBER: Int = 21
        private const val MIN_NUMBER: Int = 1
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