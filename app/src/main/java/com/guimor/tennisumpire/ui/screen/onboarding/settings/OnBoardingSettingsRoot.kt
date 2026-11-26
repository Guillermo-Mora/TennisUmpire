package com.guimor.tennisumpire.ui.screen.onboarding.settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.guimor.tennisumpire.preferences_data_store.PreferencesDataStoreEvent
import com.guimor.tennisumpire.preferences_data_store.PreferencesDataStoreViewModel

@Composable
fun OnBoardingSettingsRoot(
    onNextPage: () -> Unit,
    preferencesDataStoreViewModel: PreferencesDataStoreViewModel =
        viewModel(factory = PreferencesDataStoreViewModel.Factory)
) {
    val uiState by preferencesDataStoreViewModel.userPreferencesDataStore.collectAsStateWithLifecycle()
    OnBoardingSettingsScreen(
        onNextPage = {
            onNextPage()
            preferencesDataStoreViewModel.onEvent(PreferencesDataStoreEvent.OnFinishOnBoarding)
        },
        uiState = uiState,
        onEvent = preferencesDataStoreViewModel::onEvent,
    )
}