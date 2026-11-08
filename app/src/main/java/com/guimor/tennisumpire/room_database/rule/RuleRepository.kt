package com.guimor.tennisumpire.room_database.rule

import androidx.paging.PagingSource
import com.guimor.tennisumpire.domain.operation_result.result_type.ResultType

interface RuleRepository {
    fun getAllRules(): PagingSource<Int, Rule>

    suspend fun insertRule(rule: Rule): ResultType

    suspend fun getRule(ruleUid: Int): Rule

    suspend fun deleteRule(ruleUid: Int): ResultType

    suspend fun editRule(rule: Rule): ResultType
}