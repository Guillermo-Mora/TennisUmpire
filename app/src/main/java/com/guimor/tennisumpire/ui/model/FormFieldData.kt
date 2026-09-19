package com.guimor.tennisumpire.ui.model

import com.guimor.tennisumpire.domain.error.OperationResult

data class FormFieldData(
    val value: String = "",
    val error: OperationResult.Error? = null
)

data class FormFieldDataType<T>(
    val value: T? = null,
    val error: OperationResult.Error? = null
)

fun String.getValueOrNull(): String? {
    return this.ifEmpty { null }
}