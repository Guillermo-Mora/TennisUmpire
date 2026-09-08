package com.guimor.tennisumpire.preferences_data_store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.guimor.tennisumpire.dependency_injection.MyApplication
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val userPreferencesRepository: UserPreferencesRepository,
    //private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val userSettings: StateFlow<Settings> = userPreferencesRepository.userSettingsFlow
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = Settings.LoadingSettings
        )

    suspend fun getUserSettingsValue(): Settings.LoadedSettings =
        userPreferencesRepository.getUserSettingsValue()

    fun finishOnBoarding() {
        viewModelScope.launch {
            userPreferencesRepository.finishOnBoarding()
        }
    }
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                //Used for saving viewModel properties and then get them again when
                //the viewmodel is instantiated in another place
                //val savedStateHandle = createSavedStateHandle()
                val userPreferencesRepository =
                    (this[APPLICATION_KEY] as MyApplication).appModule.userPreferencesRepository
                SettingsViewModel(
                    userPreferencesRepository = userPreferencesRepository,
                    //savedStateHandle = savedStateHandle
                )
            }
        }
    }
}