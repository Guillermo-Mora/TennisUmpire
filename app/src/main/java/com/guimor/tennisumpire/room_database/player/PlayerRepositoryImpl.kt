package com.guimor.tennisumpire.room_database.player

import android.database.sqlite.SQLiteConstraintException
import com.guimor.tennisumpire.domain.error.DatabaseError
import com.guimor.tennisumpire.domain.error.MessageResult
import com.guimor.tennisumpire.domain.error.OperationResult
import com.guimor.tennisumpire.domain.error.SuccessMessageResult
import kotlinx.coroutines.flow.Flow

//Here I have to catch errors such as unique key being duplicated
class PlayerRepositoryImpl(
    val playerDao: PlayerDao
) : PlayerRepository {
    override fun getAllPlayers(): Flow<List<Player>> {
        return playerDao.getAllPlayers()
    }

    override suspend fun insertPlayer(
        player: Player
    ): MessageResult {
        try {
            playerDao.insertPlayer(player)
        } catch (_: SQLiteConstraintException) {
            println("Unique key error")
            return DatabaseError.UNIQUE_KEY_ERROR
            //I will return a type of interface that can be either Error Success Type.
            // The UI Will receive this and if its error, will show the error message,
            //while if its success, it will just show a toast indicating the operation
            //has been successfully completed.
        }
        return SuccessMessageResult.PLAYER_CREATED
    }

    override suspend fun deletePlayer(
        player: Player
    ): MessageResult {
        playerDao.deletePlayer(player)
        //Not implemented yet
        return SuccessMessageResult.PLAYER_DELETED
    }
}