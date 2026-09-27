package com.guimor.tennisumpire.room_database.player

import com.guimor.tennisumpire.domain.error.MessageResult
import kotlinx.coroutines.flow.Flow

interface PlayerRepository {
    fun getAllPlayers(): Flow<List<Player>>
    suspend fun insertPlayer(player: Player): MessageResult
    suspend fun deletePlayer(playerUid: Int): MessageResult

    suspend fun toggleAddPlayerToFavourites(playerUid: Int)
}