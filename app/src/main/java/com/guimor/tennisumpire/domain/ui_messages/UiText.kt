package com.guimor.tennisumpire.domain.ui_messages

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.guimor.tennisumpire.R
import com.guimor.tennisumpire.domain.operation_result.result_type.DatabaseError
import com.guimor.tennisumpire.domain.operation_result.result_type.FileManagerError
import com.guimor.tennisumpire.domain.operation_result.result_type.FormatError
import com.guimor.tennisumpire.domain.operation_result.result_type.ResultType
import com.guimor.tennisumpire.domain.operation_result.result_type.DatabaseSuccess

data class UiText(
    @param:StringRes val id: Int,
    @param:StringRes val argId: Int? = null,
    val argString: String? = null
)

data class ResultWithUiText(
    val uiText: UiText,
    val resultType: ResultType
)

fun ResultType.toResultWithUiText(
    @StringRes argId: Int? = null,
    argString: String? = null
): ResultWithUiText {
    return ResultWithUiText(
        uiText = this.toUiText(
            argId, argString
        ),
        resultType = this
    )
}

val UiText.value: String
    @Composable
    get() = this.argId?.let {
        this.argString?.let { string ->
            stringResource(this.id, stringResource(it, string))
        } ?: stringResource(this.id, stringResource(it))
    } ?: this.argString?.let {
        stringResource(this.id, it)
    } ?:
    stringResource(this.id)

fun ResultType.toUiText(
    @StringRes argId: Int? = null,
    argString: String? = null
): UiText = when(this) {
    DatabaseError.REGISTRY_ALREADY_EXISTS -> UiText(R.string.already_exists, argId, argString)
    DatabaseError.REGISTRY_NOT_EXISTS -> UiText(R.string.no_longer_exists, argId, argString)
    FileManagerError.FILE_DOESNT_EXISTS -> UiText(R.string.file_doesn_t_exists)
    FileManagerError.CANT_MOVE_FILE -> UiText(R.string.file_can_t_be_moved)
    FileManagerError.CANT_CREATE_DIRECTORY -> UiText(R.string.can_t_create_directory)
    FormatError.IS_REQUIRED -> UiText(R.string.this_field_is_required)
    FormatError.IS_BLANK -> UiText(R.string.this_field_can_t_be_blank)
    FormatError.INVALID_NUMBER -> UiText(R.string.invalid_number)
    FormatError.INVALID_DATE_FORMAT -> UiText(R.string.invalid_date_format)
    DatabaseSuccess.REGISTRY_CREATED -> UiText(R.string.registry_created, argId, argString)
    DatabaseSuccess.REGISTRY_DELETED -> UiText(R.string.registry_deleted)
    DatabaseSuccess.REGISTRY_EDITED -> UiText(R.string.registry_edited)
}