package com.guimor.tennisumpire.room_database.rule

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface RuleDao {
    @Query("SELECT * FROM rule ORDER BY name ASC")
    fun getAllRules(): PagingSource<Int, Rule>

    @Insert
    suspend fun insertRule(rule: Rule)

    @Query("SELECT * FROM rule WHERE uid = :ruleUid")
    suspend fun getRule(ruleUid: Int): Rule

    @Query("DELETE FROM rule WHERE uid = :ruleUid")
    suspend fun deleteRule(ruleUid: Int): Int

    @Update
    suspend fun editRule(rule: Rule)
}