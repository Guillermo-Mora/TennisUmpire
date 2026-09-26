package com.guimor.tennisumpire.domain.error

import com.guimor.tennisumpire.R

enum class FileManagerError(override val messageId: Int) : Error {
    FILE_DOESNT_EXISTS(R.string.file_doesn_t_exists),
    CANT_MOVE_FILE(R.string.file_can_t_be_moved),
    CANT_CREATE_FILE_DIRECTORY(R.string.directory_for_the_file_coudn_t_be_created)
}