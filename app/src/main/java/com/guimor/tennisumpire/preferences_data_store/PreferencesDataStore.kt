package com.guimor.tennisumpire.preferences_data_store

import com.guimor.tennisumpire.domain.model.Height
import com.guimor.tennisumpire.domain.model.Weight

sealed class PreferencesDataStore {
        data class LoadedPreferencesDataStore(
                val isOnBoardingFinished: Boolean = false,
                val heightFormat: Height = Height.CENTIMETERS,
                val weightFormat: Weight = Weight.KILOGRAMS
        ) : PreferencesDataStore()

        object LoadingPreferencesDataStore : PreferencesDataStore()
}

fun <T>PreferencesDataStore.value(
        function: (PreferencesDataStore.LoadedPreferencesDataStore) -> T
): T? = when(this) {
        is PreferencesDataStore.LoadedPreferencesDataStore -> function(this)
        PreferencesDataStore.LoadingPreferencesDataStore -> null
}