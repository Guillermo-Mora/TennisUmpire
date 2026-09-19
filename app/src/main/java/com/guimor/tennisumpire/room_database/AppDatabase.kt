package com.guimor.tennisumpire.room_database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.guimor.tennisumpire.room_database.converter.LocalDateConverter
import com.guimor.tennisumpire.room_database.player.Player
import com.guimor.tennisumpire.room_database.player.PlayerDao

@Database(
    entities = [Player::class],
    version = 1
)
@TypeConverters(
    LocalDateConverter::class
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun playerDao(): PlayerDao
}