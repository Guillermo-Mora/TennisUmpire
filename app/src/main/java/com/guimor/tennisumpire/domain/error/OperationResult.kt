package com.guimor.tennisumpire.domain.error

sealed interface OperationResult<out T> {
    data class SuccessResult<T>(val value: T) : OperationResult<T>
    data class ErrorResult(val error: Error) : OperationResult<Nothing>
}


sealed interface MessageResult { val messageId: Int }
sealed interface Error : MessageResult
sealed interface Success : MessageResult