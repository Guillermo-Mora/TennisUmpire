package com.guimor.tennisumpire

import android.content.Context
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.getValue
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.preferencesOf
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.guimor.tennisumpire.domain.model.preferences.Height
import com.guimor.tennisumpire.domain.model.preferences.Theme
import com.guimor.tennisumpire.domain.model.preferences.Weight
import com.guimor.tennisumpire.preferences_data_store.PreferencesDataStoreKeys
import com.guimor.tennisumpire.preferences_data_store.PreferencesDataStoreViewModel
import com.guimor.tennisumpire.ui.navigation.NavigationRoot
import com.guimor.tennisumpire.ui.theme.TennisUmpireTheme

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = "settings",
    corruptionHandler = ReplaceFileCorruptionHandler {
        preferencesOf(
            PreferencesDataStoreKeys.IS_ONBOARDING_FINISHED to true,
            PreferencesDataStoreKeys.HEIGHT_FORMAT to Height.CENTIMETERS.name,
            PreferencesDataStoreKeys.WEIGHT_FORMAT to Weight.KILOGRAMS.name,
            PreferencesDataStoreKeys.THEME to Theme.SYSTEM.name
        )
    }
)
class MainActivity : AppCompatActivity() {
    private val preferencesDataStoreViewModel: PreferencesDataStoreViewModel
            by viewModels { PreferencesDataStoreViewModel.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onAppLaunch(context = this)
        enableEdgeToEdge()
        setContent {
            val themeState by preferencesDataStoreViewModel.theme.collectAsStateWithLifecycle()
            TennisUmpireTheme(
                theme = themeState
            ) {
                NavigationRoot()
            }
        }
    }
}