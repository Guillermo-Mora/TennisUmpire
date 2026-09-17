package com.guimor.tennisumpire.domain.error

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.guimor.tennisreferee.R

@Composable
    fun Error.getErrorMessage(): String {
    return when (this) {
        is FormatError -> this.getErrorMessage()
    }
}

@Composable
private fun FormatError.getErrorMessage() = when (this) {
    FormatError.IS_REQUIRED -> stringResource(R.string.this_field_is_required)
    FormatError.IS_BLANK -> stringResource(R.string.this_field_can_t_be_blank)
    FormatError.INVALID_NUMBER -> stringResource(R.string.invalid_number)
    FormatError.INVALID_DATE_FORMAT -> stringResource(R.string.invalid_date_format)
    FormatError.FORM_CONTAINS_ERRORS -> "Please fix the errors in the highlighted fields above"
}