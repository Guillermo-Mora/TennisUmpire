package com.guimor.tennisumpire.domain.model.rule

sealed class RuleServerChangesOn(open val quantity: Int) {
    data class OneThenEveryQuantity(override val quantity: Int) : RuleServerChangesOn(quantity)
    data class EveryQuantity(override val quantity: Int) : RuleServerChangesOn(quantity)
}