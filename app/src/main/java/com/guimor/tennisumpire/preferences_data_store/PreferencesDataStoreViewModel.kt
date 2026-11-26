package com.guimor.tennisumpire.preferences_data_store

import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.guimor.tennisumpire.dependency_injection.MyApplication
import com.guimor.tennisumpire.domain.SYSTEM_DEFAULT_LANGUAGE
import com.guimor.tennisumpire.domain.model.preferences.Height
import com.guimor.tennisumpire.domain.model.preferences.Theme
import com.guimor.tennisumpire.domain.model.preferences.Weight
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class PreferencesDataStoreViewModel(
    private val userPreferencesRepository: UserPreferencesRepository,
    //private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val userPreferencesDataStore: StateFlow<PreferencesDataStore> =
        userPreferencesRepository.userPreferencesDataStoreFlow
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = PreferencesDataStore.LoadingPreferencesDataStore
            )

    val theme: StateFlow<Theme> =
        userPreferencesRepository.themeFlow
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = Theme.SYSTEM
            )

    fun onEvent(event: PreferencesDataStoreEvent) {
        when (event) {
            is PreferencesDataStoreEvent.OnChangeHeightFormat -> changeHeightFormat(
                height = event.height
            )

            is PreferencesDataStoreEvent.OnChangeTheme -> changeTheme(
                theme = event.theme
            )

            is PreferencesDataStoreEvent.OnChangeWeightFormat -> changeWeightFormat(
                weight = event.weight
            )

            PreferencesDataStoreEvent.OnFinishOnBoarding -> finishOnBoarding()
            is PreferencesDataStoreEvent.OnChangeLanguage -> changeLanguage(language = event.language)
        }
    }

    suspend fun getUserSettingsValue(): PreferencesDataStore.LoadedPreferencesDataStore {
        return userPreferencesRepository.getUserSettingsValue()
    }

    fun changeLanguage(language: String) {
        val selectedLanguage =
            if (language == SYSTEM_DEFAULT_LANGUAGE) null
            else language
        AppCompatDelegate
            .setApplicationLocales(LocaleListCompat.forLanguageTags(selectedLanguage))
    }

    fun finishOnBoarding() {
        viewModelScope.launch {
            userPreferencesRepository.finishOnBoarding()
        }
    }

    fun changeWeightFormat(weight: Weight) {
        viewModelScope.launch {
            userPreferencesRepository.changeWeightFormat(weight)
        }
    }

    fun changeHeightFormat(height: Height) {
        viewModelScope.launch {
            userPreferencesRepository.changeHeightFormat(height)
        }
    }

    fun changeTheme(theme: Theme) {
        viewModelScope.launch {
            userPreferencesRepository.changeTheme(theme)
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                //Used for saving viewModel properties and then get them again when
                //the viewmodel is instantiated in another place
                //val savedStateHandle = createSavedStateHandle()
                val userPreferencesRepository = MyApplication.appModule.userPreferencesRepository
                PreferencesDataStoreViewModel(
                    userPreferencesRepository = userPreferencesRepository,
                    //savedStateHandle = savedStateHandle
                )
            }
        }
    }
}