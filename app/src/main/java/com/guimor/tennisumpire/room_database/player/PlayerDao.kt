package com.guimor.tennisumpire.room_database.player

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {
    @Query("SELECT * FROM player ORDER BY last_name ASC")
    fun getAllPlayers(): Flow<List<Player>>

    @Insert
    suspend fun insertPlayer(player: Player)

    @Delete
    suspend fun deletePlayer(player: Player)
}