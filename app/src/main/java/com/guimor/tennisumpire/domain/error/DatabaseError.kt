package com.guimor.tennisumpire.domain.error

import com.guimor.tennisreferee.R


enum class DatabaseError(override val messageId: Int) : OperationResult.Error {
    UNIQUE_KEY_ERROR(R.string.albania)
}