package com.guimor.tennisumpire.preferences_data_store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.guimor.tennisumpire.dependency_injection.MyApplication
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class PreferencesDataStoreViewModel(
    private val userPreferencesRepository: UserPreferencesRepository,
    //private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val userPreferencesDataStore: StateFlow<PreferencesDataStore> = userPreferencesRepository.userPreferencesDataStoreFlow
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = PreferencesDataStore.LoadingPreferencesDataStore
        )

    suspend fun getUserSettingsValue(): PreferencesDataStore.LoadedPreferencesDataStore =
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
                val userPreferencesRepository = MyApplication.appModule.userPreferencesRepository
                PreferencesDataStoreViewModel(
                    userPreferencesRepository = userPreferencesRepository,
                    //savedStateHandle = savedStateHandle
                )
            }
        }
    }
}