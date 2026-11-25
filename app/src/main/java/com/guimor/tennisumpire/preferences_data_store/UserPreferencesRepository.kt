package com.guimor.tennisumpire.preferences_data_store

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.guimor.tennisumpire.domain.model.Height
import com.guimor.tennisumpire.domain.model.Weight
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class UserPreferencesRepository(
    private val dataStore: DataStore<Preferences>
) {
    val userPreferencesDataStoreFlow: Flow<PreferencesDataStore> =
        dataStore.data.map {
            PreferencesDataStore.LoadedPreferencesDataStore(
                isOnBoardingFinished = it[PreferencesDataStoreKeys.IS_ONBOARDING_FINISHED] ?: false,
                heightFormat = it[PreferencesDataStoreKeys.HEIGHT_FORMAT].toEnum(Height.CENTIMETERS),
                weightFormat = it[PreferencesDataStoreKeys.WEIGHT_FORMAT].toEnum(Weight.KILOGRAMS)
            )
        }

    suspend fun getUserSettingsValue(): PreferencesDataStore.LoadedPreferencesDataStore {
        val settings = dataStore.data.first()
        return PreferencesDataStore.LoadedPreferencesDataStore(
            isOnBoardingFinished = settings[PreferencesDataStoreKeys.IS_ONBOARDING_FINISHED]
                ?: false,
            heightFormat = settings[PreferencesDataStoreKeys.HEIGHT_FORMAT].toEnum(Height.CENTIMETERS),
            weightFormat = settings[PreferencesDataStoreKeys.WEIGHT_FORMAT].toEnum(Weight.KILOGRAMS)
        )
    }

    suspend fun finishOnBoarding() {
        dataStore.edit {
            it[PreferencesDataStoreKeys.IS_ONBOARDING_FINISHED] = true
        }
    }

    suspend fun changeWeightFormat(weight: Weight) {
        dataStore.edit {
            it[PreferencesDataStoreKeys.WEIGHT_FORMAT] = weight.name
        }
    }

    suspend fun changeHeightFormat(height: Height) {
        dataStore.edit {
            it[PreferencesDataStoreKeys.HEIGHT_FORMAT] = height.name
        }
    }

    private inline fun <reified T : Enum<T>> String?.toEnum(
        defaultValue: T
    ): T = this?.let { name -> enumValues<T>().firstOrNull { it.name == name } } ?: defaultValue
}