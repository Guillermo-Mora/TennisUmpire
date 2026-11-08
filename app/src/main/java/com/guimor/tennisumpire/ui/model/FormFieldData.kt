package com.guimor.tennisumpire.ui.model

import com.guimor.tennisumpire.domain.operation_result.result_type.ErrorResult

data class FormFieldData(
    val value: String = "",
    val error: ErrorResult? = null
)

data class FormFieldDataType<T>(
    val value: T? = null,
    val error: ErrorResult? = null
)

fun String.getValueOrNull(): String? {
    return this.ifEmpty { null }
}