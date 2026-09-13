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
    val userPreferencesDataStoreFlow: Flow<PreferencesDataStore> =
        dataStore.data.map {
            PreferencesDataStore.LoadedPreferencesDataStore(
                isOnBoardingFinished = it[PreferencesDataStoreKeys.IS_ONBOARDING_FINISHED] ?: false
            )
        }

    suspend fun getUserSettingsValue(): PreferencesDataStore.LoadedPreferencesDataStore {
        val settings = dataStore.data.first()
        return PreferencesDataStore.LoadedPreferencesDataStore(
            settings[PreferencesDataStoreKeys.IS_ONBOARDING_FINISHED] ?: false
        )
    }

    suspend fun finishOnBoarding() {
        dataStore.edit {
            it[PreferencesDataStoreKeys.IS_ONBOARDING_FINISHED] = true
        }
    }
}