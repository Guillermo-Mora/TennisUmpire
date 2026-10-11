package com.guimor.tennisumpire.room_database.player

import androidx.paging.PagingSource
import com.guimor.tennisumpire.domain.error.MessageResult
import kotlinx.coroutines.flow.Flow

interface PlayerRepository {
    fun getAllPlayers(): PagingSource<Int, Player>
    suspend fun insertPlayer(player: Player): MessageResult
    suspend fun getPlayer(playerUid: Int): Player
    fun getPlayerFlow(playerUid: Int): Flow<Player>
    suspend fun deletePlayer(playerUid: Int): MessageResult
    suspend fun editPlayer(player: Player): MessageResult
    suspend fun toggleAddPlayerToFavourites(playerUid: Int)
}