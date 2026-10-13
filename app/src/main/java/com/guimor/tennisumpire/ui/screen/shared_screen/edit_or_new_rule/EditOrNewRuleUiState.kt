package com.guimor.tennisumpire.ui.screen.shared_screen.edit_or_new_rule

import com.guimor.tennisumpire.domain.model.rule.RuleOnGameDeuce
import com.guimor.tennisumpire.domain.model.rule.RuleSetType
import com.guimor.tennisumpire.domain.model.rule.RuleSetsQuantityType
import com.guimor.tennisumpire.domain.model.rule.RuleTiebreakDecider
import com.guimor.tennisumpire.domain.model.rule.RuleTiebreakStartsOn
import com.guimor.tennisumpire.domain.operation_result.result_type.ResultType
import com.guimor.tennisumpire.ui.model.FormFieldData
import com.guimor.tennisumpire.ui_state.BaseUiState

data class EditOrNewRuleUiState(
    val scrollToErrorSection: Int = -1,
    val operationResult: ResultType? = null,
    //Rules
    val ruleName: FormFieldData = FormFieldData(),
    val ruleSetsQuantityType: RuleSetsQuantityType? = null,
    val ruleSetsQuantity: FormFieldData = FormFieldData(),
    //Sets rules
    val ruleGlobalSetType: RuleSetType? = null,
    val ruleGlobalGamesPerSet: FormFieldData = FormFieldData(),
    val ruleGlobalOnGameDeuce: RuleOnGameDeuce? = null,
    val ruleGlobalTiebreakStartsOn: RuleTiebreakStartsOn? = null,
    val ruleGlobalPointsPerTiebreak: FormFieldData = FormFieldData(),
    val ruleGlobalTiebreakDecider: RuleTiebreakDecider? = null,
    //Check for enabling deciding set rules
    val areDecidingSetRulesDifferent: Boolean = false,
    //Deciding set rules
    val ruleDecidingSetType: RuleSetType? = null,
    val ruleDecidingGamesPerSet: FormFieldData = FormFieldData(),
    val ruleDecidingOnGameDeuce: RuleOnGameDeuce? = null,
    val ruleDecidingTiebreakStartsOn: RuleTiebreakStartsOn? = null,
    val ruleDecidingPointsPerTiebreak: FormFieldData = FormFieldData(),
    val ruleDecidingTiebreakDecider: RuleTiebreakDecider? = null,
): BaseUiState()