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
        private const val EVEN_QUANTITY = "even_quantity"
        private const val ODD_QUANTITY = "odd_quantity"
        private const val ONE_THEN_ALWAYS_TWO = "one_then_always_two"
        private const val EVERY_QUANTITY = "every_quantity"

        private fun RuleServerChangesOn.convertToDatabase(): String = when (this) {
            RuleServerChangesOn.EvenQuantity -> EVEN_QUANTITY
            RuleServerChangesOn.OddQuantity -> ODD_QUANTITY
            RuleServerChangesOn.OneThenAlwaysTwo -> ONE_THEN_ALWAYS_TWO
            is RuleServerChangesOn.EveryQuantity -> "$EVERY_QUANTITY${this.quantity}"
        }

        private fun String.convertFromDatabase(): RuleServerChangesOn = when (this) {
            EVEN_QUANTITY -> RuleServerChangesOn.EvenQuantity
            ODD_QUANTITY -> RuleServerChangesOn.OddQuantity
            ONE_THEN_ALWAYS_TWO -> RuleServerChangesOn.OneThenAlwaysTwo
            else -> RuleServerChangesOn.EveryQuantity(this.substringAfter(EVERY_QUANTITY).toInt())
        }
    }
}