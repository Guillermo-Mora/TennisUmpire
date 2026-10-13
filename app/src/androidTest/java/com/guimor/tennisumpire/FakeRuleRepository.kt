package com.guimor.tennisumpire

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.guimor.tennisumpire.domain.model.rule.RuleOnGameDeuce
import com.guimor.tennisumpire.domain.model.rule.RuleSetType
import com.guimor.tennisumpire.domain.model.rule.RuleSetsQuantityType
import com.guimor.tennisumpire.domain.model.rule.RuleTiebreakDecider
import com.guimor.tennisumpire.domain.model.rule.RuleTiebreakStartsOn
import com.guimor.tennisumpire.domain.operation_result.result_type.DatabaseSuccess
import com.guimor.tennisumpire.domain.operation_result.result_type.ResultType
import com.guimor.tennisumpire.room_database.rule.Rule
import com.guimor.tennisumpire.room_database.rule.RuleRepository
import com.guimor.tennisumpire.room_database.rule.SetRules

class FakeRuleRepository: RuleRepository {
    override fun getAllRules(): PagingSource<Int, Rule> {
        return object : PagingSource<Int, Rule>() {
            override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Rule> {
                return LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }

            override fun getRefreshKey(state: PagingState<Int, Rule>): Int {
                return 1
            }
        }
    }

    override suspend fun insertRule(rule: Rule): ResultType {
        return DatabaseSuccess.REGISTRY_EDITED
    }

    override suspend fun getRule(ruleUid: Int): Rule {
        return Rule(
            uid = 1,
            name = "Demo rule",
            setsQuantityType = RuleSetsQuantityType.BEST_OF,
            setsQuantity = 3,
            setRules = SetRules(
                setType = RuleSetType.GAMES,
                gamesPerSet = 6,
                onGameDeuce = RuleOnGameDeuce.ADVANTAGE,
                tiebreakStartsOn = RuleTiebreakStartsOn.MAX_GAMES_EQUALITY,
                pointsPerTiebreak = 7,
                tiebreakDecider = RuleTiebreakDecider.TWO_POINTS_DIFFERENCE
            ),
            decidingSetRules = null
        )
    }

    override suspend fun deleteRule(ruleUid: Int): ResultType {
        return DatabaseSuccess.REGISTRY_DELETED
    }

    override suspend fun editRule(rule: Rule): ResultType {
        return DatabaseSuccess.REGISTRY_EDITED
    }
}
