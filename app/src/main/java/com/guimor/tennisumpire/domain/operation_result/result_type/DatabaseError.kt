package com.guimor.tennisumpire.domain.operation_result.result_type

enum class DatabaseError : ErrorResult {
    REGISTRY_ALREADY_EXISTS,
    REGISTRY_NOT_EXISTS
}