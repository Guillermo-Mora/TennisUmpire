package com.guimor.tennisumpire.preferences_data_store

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class UserPreferencesRepository(
    private val dataStore: DataStore<Preferences>
) {
    val userSettingsFlow: Flow<Settings> =
        dataStore.data.map {
            Settings.LoadedSettings(
                isOnBoardingFinished = it[SettingsKeys.IS_ONBOARDING_FINISHED] ?: false
            )
        }

    suspend fun getUserSettingsValue(): Settings.LoadedSettings {
        val settings = dataStore.data.first()
        return Settings.LoadedSettings(
            settings[SettingsKeys.IS_ONBOARDING_FINISHED] ?: false
        )
    }

    suspend fun finishOnBoarding() {
        dataStore.edit {
            it[SettingsKeys.IS_ONBOARDING_FINISHED] = true
        }
    }
}