package com.guimor.tennisumpire.room_database.player

import android.database.sqlite.SQLiteConstraintException
import com.guimor.tennisumpire.domain.error.DatabaseError
import com.guimor.tennisumpire.domain.error.OperationResult
import kotlinx.coroutines.flow.Flow

//Here I have to catch errors such as unique key being duplicated
class PlayerRepository(
    val playerDao: PlayerDao
) {
    fun getAllPlayers(): Flow<List<Player>> {
        return playerDao.getAllPlayers()
    }

    suspend fun insertPlayer(player: Player): OperationResult {
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
        return OperationResult.Success.PLAYER_CREATED
    }

    suspend fun deletePlayer(player: Player) {
        playerDao.deletePlayer(player)
    }
}