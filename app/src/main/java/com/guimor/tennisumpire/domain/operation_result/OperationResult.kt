package com.guimor.tennisumpire.domain.operation_result

import com.guimor.tennisumpire.domain.operation_result.result_type.ErrorResult

sealed interface OperationResult<out T> {
    data class SuccessOperation<T>(val value: T) : OperationResult<T>
    data class ErrorOperation(val error: ErrorResult) : OperationResult<Nothing>
}