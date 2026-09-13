package com.guimor.tennisumpire.preferences_data_store

sealed class PreferencesDataStore {
        data class LoadedPreferencesDataStore(
                val isOnBoardingFinished: Boolean = false
        ) : PreferencesDataStore()

        object LoadingPreferencesDataStore : PreferencesDataStore()
}