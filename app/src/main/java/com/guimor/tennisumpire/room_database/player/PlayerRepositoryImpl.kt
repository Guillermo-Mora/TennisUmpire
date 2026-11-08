package com.guimor.tennisumpire.room_database.player

import android.database.sqlite.SQLiteConstraintException
import androidx.paging.PagingSource
import com.guimor.tennisumpire.domain.operation_result.result_type.DatabaseError
import com.guimor.tennisumpire.domain.operation_result.result_type.ResultType
import com.guimor.tennisumpire.domain.operation_result.result_type.DatabaseSuccess
import kotlinx.coroutines.flow.Flow

class PlayerRepositoryImpl(
    val playerDao: PlayerDao
) : PlayerRepository {
    override fun getAllPlayers(): PagingSource<Int, Player> {
        return playerDao.getAllPlayers()
    }

    override suspend fun insertPlayer(
        player: Player
    ): ResultType {
        try {
            playerDao.insertPlayer(player)
        } catch (_: SQLiteConstraintException) {
            return DatabaseError.REGISTRY_ALREADY_EXISTS
        }
        return DatabaseSuccess.REGISTRY_CREATED
    }

    override suspend fun getPlayer(
        playerUid: Int
    ): Player {
        return playerDao.getPlayer(playerUid)
    }

    override fun getPlayerFlow(playerUid: Int): Flow<Player> {
        return playerDao.getPlayerFlow(playerUid)
    }

    override suspend fun deletePlayer(
        playerUid: Int
    ): ResultType {
        playerDao.deletePlayer(playerUid).also { deletedRows ->
            return if (deletedRows >= 1) DatabaseSuccess.REGISTRY_DELETED
            else DatabaseError.REGISTRY_NOT_EXISTS
        }
    }

    override suspend fun editPlayer(
        player: Player
    ): ResultType {
        try {
            playerDao.editPlayer(player)
        } catch (_: SQLiteConstraintException) {
            return DatabaseError.REGISTRY_ALREADY_EXISTS
        }
        return DatabaseSuccess.REGISTRY_EDITED
    }

    override suspend fun toggleAddPlayerToFavourites(playerUid: Int) {
        playerDao.toggleAddPlayerToFavourites(playerUid)
    }
}