package com.guimor.tennisumpire.ui.components.form

import com.guimor.tennisumpire.ui.components.error.Error

data class FormFieldData(
    val value: String = "",
    val error: Error? = null
)

data class FormFieldDataType<T>(
    val value: T? = null,
    val error: Error? = null
)