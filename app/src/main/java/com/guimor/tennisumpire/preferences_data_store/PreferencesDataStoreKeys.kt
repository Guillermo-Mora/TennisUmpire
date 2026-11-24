package com.guimor.tennisumpire.preferences_data_store

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object PreferencesDataStoreKeys {
    val IS_ONBOARDING_FINISHED = booleanPreferencesKey("is_onboarding_finished")
    val HEIGHT_FORMAT = stringPreferencesKey("height_format")
    val WEIGHT_FORMAT = stringPreferencesKey("weight_format")
}