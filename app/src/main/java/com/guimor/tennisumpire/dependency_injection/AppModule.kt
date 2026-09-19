package com.guimor.tennisumpire.dependency_injection

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.AndroidSQLiteDriver
import com.guimor.tennisumpire.dataStore
import com.guimor.tennisumpire.preferences_data_store.UserPreferencesRepository
import com.guimor.tennisumpire.room_database.AppDatabase
import com.guimor.tennisumpire.room_database.player.PlayerRepository

interface AppModule {
    val db : AppDatabase
    val userPreferencesRepository: UserPreferencesRepository
    val playerRepository: PlayerRepository
}

class AppModuleImpl(
    private val appContext: Context
) : AppModule {
    //Same repository for all app, as the value is only instantiated once
    // With get() = I could do new repositories for each time I need them, but in this
    // case I want to use the same, so just '='.
    override val db = Room.databaseBuilder<AppDatabase>(
        context = appContext,
        name = "tennis-umpire-db"
    ).setDriver(AndroidSQLiteDriver()).build()
    override val userPreferencesRepository: UserPreferencesRepository =
        UserPreferencesRepository(dataStore = appContext.dataStore)
    override val playerRepository: PlayerRepository = PlayerRepository(
        playerDao = db.playerDao()
    )
}