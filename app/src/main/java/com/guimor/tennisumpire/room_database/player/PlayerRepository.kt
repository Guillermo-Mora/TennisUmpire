package com.guimor.tennisumpire.room_database.player

import androidx.paging.PagingSource
import com.guimor.tennisumpire.domain.operation_result.result_type.ResultType
import kotlinx.coroutines.flow.Flow

interface PlayerRepository {
    fun getAllPlayers(): PagingSource<Int, Player>
    suspend fun insertPlayer(player: Player): ResultType
    suspend fun getPlayer(playerUid: Int): Player
    fun getPlayerFlow(playerUid: Int): Flow<Player>
    suspend fun deletePlayer(playerUid: Int): ResultType
    suspend fun editPlayer(player: Player): ResultType
    suspend fun toggleAddPlayerToFavourites(playerUid: Int)
}