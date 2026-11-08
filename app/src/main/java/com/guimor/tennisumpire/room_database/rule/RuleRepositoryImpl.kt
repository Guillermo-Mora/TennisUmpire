package com.guimor.tennisumpire.room_database.rule

import android.database.sqlite.SQLiteConstraintException
import androidx.paging.PagingSource
import com.guimor.tennisumpire.domain.operation_result.result_type.DatabaseError
import com.guimor.tennisumpire.domain.operation_result.result_type.ResultType
import com.guimor.tennisumpire.domain.operation_result.result_type.DatabaseSuccess

class RuleRepositoryImpl(
    val ruleDao: RuleDao
): RuleRepository {
    override fun getAllRules(): PagingSource<Int, Rule> {
        return ruleDao.getAllRules()
    }

    override suspend fun insertRule(
        rule: Rule
    ): ResultType {
        try {
            ruleDao.insertRule(rule)
        } catch (_: SQLiteConstraintException) {
            return DatabaseError.REGISTRY_ALREADY_EXISTS
        }
        return DatabaseSuccess.REGISTRY_CREATED
    }

    override suspend fun getRule(
        ruleUid: Int
    ): Rule {
        return ruleDao.getRule(ruleUid)
    }

    override suspend fun deleteRule(
        ruleUid: Int
    ): ResultType {
        ruleDao.deleteRule(ruleUid).also { deletedRows ->
            return if (deletedRows >= 1) DatabaseSuccess.REGISTRY_DELETED
            else DatabaseError.REGISTRY_NOT_EXISTS
        }
    }

    override suspend fun editRule(
        rule: Rule
    ): ResultType {
        try {
            ruleDao.editRule(rule)
        } catch (_: SQLiteConstraintException) {
            return DatabaseError.REGISTRY_ALREADY_EXISTS
        }
        return DatabaseSuccess.REGISTRY_EDITED
    }
}