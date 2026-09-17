package com.guimor.tennisumpire.ui.model

import com.guimor.tennisumpire.domain.error.Error

data class FormFieldData(
    val value: String = "",
    val error: Error? = null
)

data class FormFieldDataType<T>(
    val value: T? = null,
    val error: Error? = null
)