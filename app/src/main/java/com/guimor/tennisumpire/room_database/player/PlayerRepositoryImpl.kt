package com.guimor.tennisumpire.room_database.player

import android.database.sqlite.SQLiteConstraintException
import androidx.paging.PagingSource
import com.guimor.tennisumpire.domain.error.DatabaseError
import com.guimor.tennisumpire.domain.error.MessageResult
import com.guimor.tennisumpire.domain.error.SuccessMessageResult
import kotlinx.coroutines.flow.Flow

class PlayerRepositoryImpl(
    val playerDao: PlayerDao
) : PlayerRepository {
    override fun getAllPlayers(): PagingSource<Int, Player> {
        return playerDao.getAllPlayers()
    }

    override suspend fun insertPlayer(
        player: Player
    ): MessageResult {
        try {
            playerDao.insertPlayer(player)
        } catch (_: SQLiteConstraintException) {
            return DatabaseError.PLAYER_ALREADY_EXISTS
        }
        return SuccessMessageResult.PLAYER_CREATED
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
    ): MessageResult {
        playerDao.deletePlayer(playerUid).also { deletedRows ->
            return if (deletedRows >= 1) SuccessMessageResult.PLAYER_DELETED
            else DatabaseError.PLAYER_NOT_EXISTS
        }
    }

    override suspend fun editPlayer(
        player: Player
    ): MessageResult {
        try {
            playerDao.editPlayer(player)
        } catch (_: SQLiteConstraintException) {
            return DatabaseError.PLAYER_ALREADY_EXISTS
        }
        return SuccessMessageResult.PLAYER_EDITED
    }

    override suspend fun toggleAddPlayerToFavourites(playerUid: Int) {
        playerDao.toggleAddPlayerToFavourites(playerUid)
    }
}