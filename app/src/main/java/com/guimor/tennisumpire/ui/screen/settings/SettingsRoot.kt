package com.guimor.tennisumpire.ui.screen.settings

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.guimor.tennisumpire.preferences_data_store.PreferencesDataStoreViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsRoot(
    onNavigateBack: () -> Unit,
    viewModel: PreferencesDataStoreViewModel = viewModel(factory = PreferencesDataStoreViewModel.Factory)
) {
    val uiState by viewModel.userPreferencesDataStore.collectAsStateWithLifecycle()
    val snackBarHostState = remember { SnackbarHostState() }
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    SettingsScreen(
        onNavigateBack = onNavigateBack,
        uiState = uiState,
        snackBarHostState = snackBarHostState,
        scrollBehavior = scrollBehavior,
        onEvent = viewModel::onEvent
    )
}