package com.guimor.tennisumpire

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.preferencesOf
import androidx.datastore.preferences.preferencesDataStore
import com.guimor.tennisumpire.preferences_data_store.SettingsKeys
import com.guimor.tennisumpire.ui.navigation.NavigationRoot
import com.guimor.tennisumpire.ui.theme.TennisRefereeTheme

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = "settings",
    corruptionHandler = ReplaceFileCorruptionHandler {
        preferencesOf(
            SettingsKeys.IS_ONBOARDING_FINISHED to true
        )
    }
)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TennisRefereeTheme {
                TennisRefereeApp()
            }
        }
    }
}

@Composable
fun TennisRefereeApp() {
    NavigationRoot()
}