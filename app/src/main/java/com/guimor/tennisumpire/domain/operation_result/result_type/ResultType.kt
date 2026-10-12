package com.guimor.tennisumpire.domain.operation_result.result_type

sealed interface ResultType

sealed interface ErrorResult : ResultType
sealed interface SuccessResult: ResultType