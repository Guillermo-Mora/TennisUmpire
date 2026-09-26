package com.guimor.tennisumpire.room_database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.guimor.tennisumpire.room_database.converter.LocalDateConverter
import com.guimor.tennisumpire.room_database.converter.UriConverter
import com.guimor.tennisumpire.room_database.player.Player
import com.guimor.tennisumpire.room_database.player.PlayerDao

@Database(
    version = 1,
    entities = [Player::class],
    exportSchema = true,
    autoMigrations = [
        //AutoMigration(from = 1, to = 2)
    ]
)
@TypeConverters(
    LocalDateConverter::class,
    UriConverter::class
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun playerDao(): PlayerDao
}