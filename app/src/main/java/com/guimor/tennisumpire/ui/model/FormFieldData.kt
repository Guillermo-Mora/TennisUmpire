package com.guimor.tennisumpire.ui.model

import com.guimor.tennisumpire.domain.error.Error
import com.guimor.tennisumpire.domain.error.OperationResult

data class FormFieldData(
    val value: String = "",
    val error: Error? = null
)

data class FormFieldDataType<T>(
    val value: T? = null,
    val error: Error? = null
)

fun String.getValueOrNull(): String? {
    return this.ifEmpty { null }
}