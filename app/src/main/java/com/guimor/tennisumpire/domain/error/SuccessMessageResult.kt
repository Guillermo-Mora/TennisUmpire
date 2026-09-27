package com.guimor.tennisumpire.domain.error

import com.guimor.tennisumpire.R

enum class SuccessMessageResult(override val messageId: Int) : Success {
    PLAYER_CREATED(R.string.player_created),
    PLAYER_DELETED(R.string.player_deleted)
}