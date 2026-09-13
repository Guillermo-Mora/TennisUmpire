package com.guimor.tennisumpire.view_model

import com.guimor.tennisumpire.ui.components.error.Error
import com.guimor.tennisumpire.ui.components.error.FormatError
import com.guimor.tennisumpire.ui.components.form.FormFieldData
import com.guimor.tennisumpire.ui.components.form.FormFieldDataType

object ViewModelHelper {
    data class ValidationRule(
        val condition: (fieldValue: String) -> Boolean,
        val error: Error
    )

    data class ValidationRuleType<T>(
        val condition: (fieldValue: T) -> Boolean,
        val error: Error
    )

    fun validateField(
        formFieldData: FormFieldData,
        required: Boolean = false,
        vararg validationRules: ValidationRule
    ): FormFieldData? {
        val fieldValue = formFieldData.value
        if (!required && fieldValue.isEmpty()) return null
        if (required && fieldValue.isEmpty()) return formFieldData.copy(error = FormatError.IS_REQUIRED)
        validationRules.forEach {
            if (it.condition(fieldValue)) {
                return formFieldData.copy(error = it.error)
            }
        }
        return null
    }

    fun <T> validateField(
        formFieldData: FormFieldDataType<T>,
        required: Boolean = false,
        vararg validationRules: ValidationRuleType<T>
    ): FormFieldDataType<T>? {
        val fieldValue = formFieldData.value
        if (!required && fieldValue == null) return null
        if (required && fieldValue == null) return formFieldData.copy(error = FormatError.IS_REQUIRED)
        if (fieldValue == null) return null
        validationRules.forEach {
            if (it.condition(fieldValue)) {
                return formFieldData.copy(error = it.error)
            }
        }
        return null
    }
}