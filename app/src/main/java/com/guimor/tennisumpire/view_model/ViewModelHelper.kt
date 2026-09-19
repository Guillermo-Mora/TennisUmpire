package com.guimor.tennisumpire.view_model

import com.guimor.tennisumpire.domain.error.FormatError
import com.guimor.tennisumpire.domain.error.OperationResult
import com.guimor.tennisumpire.ui.model.FormFieldData
import com.guimor.tennisumpire.ui.model.FormFieldDataType

object ViewModelHelper {
    data class ValidationRule(
        val condition: (fieldValue: String) -> Boolean,
        val error: OperationResult.Error
    )

    data class ValidationRuleType<T>(
        val condition: (fieldValue: T) -> Boolean,
        val error: OperationResult.Error
    )

    private fun validateField(
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

    private fun <T> validateField(
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

    fun isFieldError(
        formFieldData: FormFieldData,
        required: Boolean = false,
        vararg validationRules: ValidationRule,
        setError: (FormFieldData) -> Unit,
    ): Boolean {
        validateField(
            formFieldData = formFieldData,
            required = required,
            validationRules = validationRules
        )?.let {
            setError(it)
            return true
        }
        return false
    }

    fun validateForm(
        vararg formValidations: (() -> Boolean)?,
        onNoErrors: () -> Unit,
        navigateToFirstError: (firstErrorPosition: Int) -> Unit
    ) {
        var containsErrors = false
        var firstErrorPosition = -1
        formValidations.forEachIndexed { index, validateField ->
            if (containsErrors) validateField?.invoke()
            else if (validateField?.invoke() == true) {
                firstErrorPosition = index
                containsErrors = true
            }
        }
        if (containsErrors)
            navigateToFirstError(firstErrorPosition)
        else onNoErrors()
    }
}