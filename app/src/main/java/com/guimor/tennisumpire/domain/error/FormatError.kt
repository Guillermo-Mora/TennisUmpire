package com.guimor.tennisumpire.domain.error

import com.guimor.tennisreferee.R

enum class FormatError(override val messageId: Int): OperationResult.Error {
    IS_REQUIRED(R.string.this_field_is_required),
    IS_BLANK(R.string.this_field_can_t_be_blank),
    INVALID_NUMBER(R.string.invalid_number),
    INVALID_DATE_FORMAT(R.string.invalid_date_format),
}