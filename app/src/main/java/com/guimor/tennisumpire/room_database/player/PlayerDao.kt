package com.guimor.tennisumpire.room_database.player

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {
    @Query("SELECT * FROM player ORDER BY last_name ASC")
    fun getAllPlayers(): Flow<List<Player>>

    @Insert
    suspend fun insertPlayer(player: Player)

    @Query("DELETE FROM player WHERE uid = :playerUid")
    suspend fun deletePlayer(playerUid: Int): Int

    @Query("UPDATE player SET favourite = NOT favourite WHERE uid = :playerUid")
    suspend fun toggleAddPlayerToFavourites(playerUid: Int)
}