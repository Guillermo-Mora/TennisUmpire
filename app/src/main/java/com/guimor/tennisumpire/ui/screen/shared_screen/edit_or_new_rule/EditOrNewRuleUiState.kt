package com.guimor.tennisumpire.ui.screen.shared_screen.edit_or_new_rule

import com.guimor.tennisumpire.domain.model.rule.RuleOnGameDeuce
import com.guimor.tennisumpire.domain.model.rule.RuleSetDecider
import com.guimor.tennisumpire.domain.model.rule.RuleSetType
import com.guimor.tennisumpire.domain.model.rule.RuleSetsQuantityType
import com.guimor.tennisumpire.domain.model.rule.RuleTiebreakDecider
import com.guimor.tennisumpire.domain.operation_result.result_type.ResultType
import com.guimor.tennisumpire.ui.model.FormFieldData
import com.guimor.tennisumpire.ui_state.BaseUiState

data class EditOrNewRuleUiState(
    val scrollToErrorSection: Int = -1,
    val operationResult: ResultType? = null,
    //Rules
    val ruleName: FormFieldData = FormFieldData(),
    val ruleSetsQuantityType: RuleSetsQuantityType = RuleSetsQuantityType.BEST_OF,
    val ruleSetsQuantity: Int = 3,
    //Sets rules
    val ruleGlobalSetType: RuleSetType = RuleSetType.GAMES,
    val ruleGlobalGamesPerSet: Int = 6,
    val ruleGlobalOnGameDeuce: RuleOnGameDeuce = RuleOnGameDeuce.ADVANTAGE,
    val ruleGlobalSetDecider: RuleSetDecider = RuleSetDecider.TIEBREAK,
    val ruleGlobalPointsPerTiebreak: Int = 7,
    val ruleGlobalTiebreakDecider: RuleTiebreakDecider = RuleTiebreakDecider.TWO_POINTS_DIFFERENCE,
    //Check for enabling deciding set rules
    val areDecidingSetRulesDifferent: Boolean = false,
    //Deciding set rules
    val ruleDecidingSetType: RuleSetType = RuleSetType.GAMES,
    val ruleDecidingGamesPerSet: Int = 6,
    val ruleDecidingOnGameDeuce: RuleOnGameDeuce = RuleOnGameDeuce.ADVANTAGE,
    val ruleDecidingSetDecider: RuleSetDecider = RuleSetDecider.TIEBREAK,
    val ruleDecidingPointsPerTiebreak: Int = 10,
    val ruleDecidingTiebreakDecider: RuleTiebreakDecider = RuleTiebreakDecider.TWO_POINTS_DIFFERENCE,
): BaseUiState()