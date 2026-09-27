package com.guimor.tennisumpire.domain.error

import com.guimor.tennisumpire.R


enum class DatabaseError(override val messageId: Int) : Error {
    PLAYER_ALREADY_EXISTS(R.string.a_player_with_this_name_already_exists),
    PLAYER_NOT_EXISTS(R.string.player_no_longer_exists)
}