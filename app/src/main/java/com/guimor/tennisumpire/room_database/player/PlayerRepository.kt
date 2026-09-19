package com.guimor.tennisumpire.room_database.player

import com.guimor.tennisumpire.domain.error.OperationResult
import kotlinx.coroutines.flow.Flow

interface PlayerRepository {
    fun getAllPlayers(): Flow<List<Player>>
    suspend fun insertPlayer(player: Player): OperationResult
    suspend fun deletePlayer(player: Player): OperationResult
}