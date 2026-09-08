package com.guimor.tennisumpire.dependency_injection

import android.content.Context
import com.guimor.tennisumpire.dataStore
import com.guimor.tennisumpire.preferences_data_store.UserPreferencesRepository

interface AppModule {
    val userPreferencesRepository: UserPreferencesRepository
}

class AppModuleImpl(
    private val appContext: Context
) : AppModule {
    //Same repository for all app, as the value is only instantiated once
    // With get() = I could do new repositories for each time I need them
    override val userPreferencesRepository: UserPreferencesRepository =
        UserPreferencesRepository(dataStore = appContext.dataStore)
}