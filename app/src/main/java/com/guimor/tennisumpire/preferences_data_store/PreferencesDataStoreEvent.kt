package com.guimor.tennisumpire.preferences_data_store

import com.guimor.tennisumpire.domain.model.preferences.Height
import com.guimor.tennisumpire.domain.model.preferences.Theme
import com.guimor.tennisumpire.domain.model.preferences.Weight

sealed interface PreferencesDataStoreEvent {
    data object OnFinishOnBoarding : PreferencesDataStoreEvent
    data class OnChangeWeightFormat(val weight: Weight) : PreferencesDataStoreEvent
    data class OnChangeHeightFormat(val height: Height) : PreferencesDataStoreEvent
    data class OnChangeTheme(val theme: Theme) : PreferencesDataStoreEvent
    data class OnChangeLanguage(val language: String) : PreferencesDataStoreEvent
}