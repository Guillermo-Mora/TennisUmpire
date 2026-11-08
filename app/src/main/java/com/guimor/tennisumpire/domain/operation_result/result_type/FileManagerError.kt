package com.guimor.tennisumpire.domain.operation_result.result_type

enum class FileManagerError : ErrorResult {
    FILE_DOESNT_EXISTS,
    CANT_MOVE_FILE,
    CANT_CREATE_DIRECTORY
}