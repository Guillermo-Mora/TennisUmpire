package com.guimor.tennisumpire.domain.error

import com.guimor.tennisreferee.R

sealed interface OperationResult {
    val messageId: Int

    sealed interface Error : OperationResult

    enum class Success(override val messageId: Int) : OperationResult {
        PLAYER_CREATED(R.string.albania),
        PLAYER_DELETED(R.string.albania)
    }
}