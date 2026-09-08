package com.guimor.tennisumpire.ui.screen.onboarding

import androidx.lifecycle.ViewModel
import com.guimor.tennisumpire.ui_state.BaseUiState
import com.guimor.tennisumpire.view_model.UiStateHolder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class OnBoardingViewModel(
    override val _uiState: MutableStateFlow<OnBoardingUiState> = MutableStateFlow(OnBoardingUiState()),
    override val uiState: StateFlow<OnBoardingUiState> = _uiState.asStateFlow(),
) : ViewModel(),
    UiStateHolder<OnBoardingUiState> {

    }