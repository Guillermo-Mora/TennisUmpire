package com.guimor.tennisumpire.domain.model.rule

sealed interface RuleServerChangesOn {
    data object OneThenAlwaysTwo : RuleServerChangesOn
    data object OddQuantity : RuleServerChangesOn
    data object EvenQuantity : RuleServerChangesOn
    data class EveryQuantity(val quantity: Int) : RuleServerChangesOn
}