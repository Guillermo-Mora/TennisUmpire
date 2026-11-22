package com.guimor.tennisumpire.room_database.converter

import androidx.room.TypeConverter
import com.guimor.tennisumpire.domain.model.rule.RuleServerChangesOn

class RuleServerChangesOnConverter {
    @TypeConverter
    fun toDatabase(ruleServerChangesOn: RuleServerChangesOn): String {
        return ruleServerChangesOn.convertToDatabase()
    }

    @TypeConverter
    fun fromDatabase(ruleServerChangesOn: String): RuleServerChangesOn {
        return ruleServerChangesOn.convertFromDatabase()
    }

    companion object {
        private const val ONE_THEN_EVERY_QUANTITY = "one_then_every_quantity"
        private const val EVERY_QUANTITY = "every_quantity"

        private fun RuleServerChangesOn.convertToDatabase(): String = when (this) {
            is RuleServerChangesOn.OneThenEveryQuantity -> "$ONE_THEN_EVERY_QUANTITY${this.quantity}"
            is RuleServerChangesOn.EveryQuantity -> "$EVERY_QUANTITY${this.quantity}"
        }

        private fun String.convertFromDatabase(): RuleServerChangesOn =
            if (this.contains(ONE_THEN_EVERY_QUANTITY)) RuleServerChangesOn.OneThenEveryQuantity(
                this.substringAfter(ONE_THEN_EVERY_QUANTITY).toInt()
            ) else if (this.contains(EVERY_QUANTITY)) RuleServerChangesOn.EveryQuantity(
                this.substringAfter(EVERY_QUANTITY).toInt()
            )
            else {
                println("ERROR OBTAINING TYPE")
                RuleServerChangesOn.EveryQuantity(1)
            }
    }
}