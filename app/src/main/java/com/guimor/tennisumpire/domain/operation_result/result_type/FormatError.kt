package com.guimor.tennisumpire.domain.operation_result.result_type

enum class FormatError: ErrorResult {
    IS_REQUIRED,
    IS_BLANK,
    INVALID_NUMBER,
    INVALID_DATE_FORMAT
}