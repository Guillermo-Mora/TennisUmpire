package com.guimor.tennisumpire.domain.error

import com.guimor.tennisumpire.R


enum class DatabaseError(override val messageId: Int) : Error {
    UNIQUE_KEY_ERROR(R.string.albania)
}