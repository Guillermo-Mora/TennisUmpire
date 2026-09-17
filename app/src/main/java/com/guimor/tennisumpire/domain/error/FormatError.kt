package com.guimor.tennisumpire.domain.error

enum class FormatError: Error {
    IS_REQUIRED,
    IS_BLANK,
    INVALID_NUMBER,
    INVALID_DATE_FORMAT,
    FORM_CONTAINS_ERRORS
}