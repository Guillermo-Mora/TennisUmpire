package com.guimor.tennisumpire.domain.validation

object ValidationRules {
    private val GREATER_THAN_ZERO_NUMBER =
        Regex("""^(?:[1-9]\d*(?:[.,]\d+)?|0[.,]0*[1-9]\d*)$""")

    fun String.isNumberGreaterThanZero() = this.matches(GREATER_THAN_ZERO_NUMBER)
    fun String.isNotNumberGreaterThanZero() = !this.isNumberGreaterThanZero()
}