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
    val ruleSetsQuantity: Int? = null,
    //Sets rules
    val ruleGlobalSetType: RuleSetType? = null,
    val ruleGlobalGamesPerSet: Int? = null,
    val ruleGlobalOnGameDeuce: RuleOnGameDeuce? = null,
    val ruleGlobalTiebreakStartsOn: RuleTiebreakStartsOn? = null,
    val ruleGlobalPointsPerTiebreak: Int? = null,
    val ruleGlobalTiebreakDecider: RuleTiebreakDecider? = null,
    //Check for enabling deciding set rules
    val areDecidingSetRulesDifferent: Boolean = false,
    //Deciding set rules
    val ruleDecidingSetType: RuleSetType? = null,
    val ruleDecidingGamesPerSet: Int? = null,
    val ruleDecidingOnGameDeuce: RuleOnGameDeuce? = null,
    val ruleDecidingTiebreakStartsOn: RuleTiebreakStartsOn? = null,
    val ruleDecidingPointsPerTiebreak: Int? = null,
    val ruleDecidingTiebreakDecider: RuleTiebreakDecider? = null,
): BaseUiState()